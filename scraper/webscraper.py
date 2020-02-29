#DEPENDENCIES
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from article import Article
from ticker import Ticker

browser = webdriver.Chrome('/usr/local/bin/chromedriver')

# all article urls
article_urls = []

def get_forbes():

    browser.get(('https://www.forbes.com/money/'))

    # Forbes Top 10 Articles
    article_div = browser.find_element_by_xpath('//*[@id="row-2"]/div/div/div/div[1]/div/div')
    articles = article_div.find_elements_by_tag_name('article')

    forbes_article_urls = []

    for article in articles:
        stream_item_text = article.find_element_by_class_name('stream-item__text')
        h2 = stream_item_text.find_element_by_tag_name('h2')
        a = h2.find_element_by_tag_name('a')
        href = a.get_attribute('href')
        forbes_article_urls.append(href)

    article_urls.extend(forbes_article_urls)

get_forbes()
print(article_urls)
