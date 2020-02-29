#DEPENDENCIES
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from article import Article
from ticker import Ticker

browser = webdriver.Chrome('/usr/local/bin/chromedriver')

def get_forbes_URLs():

    browser.get(('https://www.forbes.com/money/'))

    # headline article
    headline_card = browser.find_element_by_xpath('/html/body/div[1]/main/div/section/div/div/div[1]/div[1]/h2')
    headline_card_a = headline_card.find_element_by_tag_name('a')
    headline_card_a_href = headline_card_a.get_attribute('href')
    headline_card_headline = browser.find_element_by_tag_name('h2').text
    headline_article = Article(headline_card_a_href, headline_card_headline, 1)
    articles = [headline_article]

    # sub-headlines
    sub_headline_car = browser.find_element_by_xpath('/html/body/div[1]/main/div/section/div/div/div[1]/div[2]')
    sub_headlines_card_list = sub_headline_car.find_elements_by_class_name('card--text')
    for sub_headline_card in sub_headlines_card_list:
        sub_headlines_card_href = sub_headline_card.find_element_by_tag_name('a').get_attribute('href')
        # filter out the links to journalist sites
        if sub_headlines_card_href.count('/') is 5:
            continue
        sub_headline_card_headline = sub_headline_card.find_element_by_tag_name('h2').text
        articles.append(Article(sub_headlines_card_href, sub_headline_card_headline, .6))

    # Forbes Side Articles
    side_article_container = browser.find_element_by_xpath('//*[@id="row-2"]/div/div/div/div[1]/div/div')
    side_article_div = side_article_container.find_elements_by_tag_name('article')

    for side_article in side_article_div:
        stream_item_text = side_article.find_element_by_class_name('stream-item__text')
        h2 = stream_item_text.find_element_by_tag_name('h2')
        a = h2.find_element_by_tag_name('a')
        href = a.get_attribute('href')
        articles.append(Article(href, a.text, .2))

    return articles


def retrieve_forbes_article_data(article):

    article_text = ''
    article_ticker = ''
    article_paragraphs = []

    browser.get((article.url))

    try:
        article_text_section = browser.find_element_by_xpath('//*[@id="article-container-0"]/div[2]/div[2]/article-body-container/div/div')
        article_paragraph_tags = article_text_section.find_elements_by_tag_name('p')
    except:
        return

    for paragraph in article_paragraph_tags:

        if '[+]' in paragraph.text:
            continue

        article_paragraphs.append(paragraph.text)



forbes_URLs = get_forbes_URLs()
for article in forbes_URLs:
    retrieve_forbes_article_data(article)
