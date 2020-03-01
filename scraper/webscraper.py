#DEPENDENCIES
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from article import Article
from ticker import Ticker
from paragraph import Paragraph
import ahocorasick
import json

browser = webdriver.Chrome('/usr/local/bin/chromedriver')

def get_forbes_articles():

    browser.get(('https://www.forbes.com/money/'))
    print('Getting forbes URLs')

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

    print('Article URLs successfully retrieved')
    return articles

def populate_companies():

    print('Parsing list of companies...')
    browser.get('https://www.value.today/world-stock-news/world-top-1000-companies-list-market-cap-july-1st-2019')

    company_names = [' S&P ', ' S&P.', 'S&P,', ' DOW ', ' DOW,', ' DOW.', ' GOOGLE ', ' GOOGLE,', ' GOOGLE.', 'ALPHABET.', ' ALPHABET ', 'ALPHABET,']
    A = ahocorasick.Automaton()

    companies_table = browser.find_element_by_xpath('//*[@id="block-creative-responsive-theme-content"]/div/div/div[2]/table[1]/tbody')
    companies_list = companies_table.find_elements_by_tag_name('tr')

    blacklist = ['TOTAL', 'SNAP', 'BOOKING', 'CREDIT', 'MATCH']

    for company in companies_list:
        company_name_point = company.find_elements_by_tag_name('td')
        try:
            company_name = company_name_point[1].find_element_by_tag_name('a').text
            company_name = company_name.upper()
            if 'INC' in company_name:
                company_name = company_name[:company_name.find('INC') - 1]
            if 'LLC' in company_name:
                company_name = company_name[:company_name.find('LLC') - 1]
            if '.,' in company_name:
                company_name = company_name[:company_name.find('.,') - 2]
            if 'LTD' in company_name:
                company_name = company_name[:company_name.find('LTD') - 1]
            if 'PLC' in company_name:
                company_name = company_name[:company_name.find('PLC') - 1]
            if 'P.L.C' in company_name:
                company_name = company_name[:company_name.find('P.L.C') - 1]
            if '(' in company_name:
                company_name = company_name[:company_name.find('(') - 1]
            if ' & ' in company_name:
                company_name = company_name[:company_name.find(' & ')]
            if 'LIMITED' in company_name:
                company_name = company_name[:company_name.find('LIMITED') - 1]
            if 'COMPAN' in company_name:
                company_name = company_name[:company_name.find('COMPAN') - 1]
            if 'LP' in company_name:
                company_name = company_name[:company_name.find('LP') - 1]
            if 'L.P' in company_name:
                company_name = company_name[:company_name.find('L.P') - 1]
            if 'CORP' in company_name:
                company_name = company_name[:company_name.find('CORP') - 1]
            if 'INTERNATIONAL' in company_name:
                company_name = company_name[:company_name.find('INTERNATIONAL') - 1]
            if 'HOLDING' in company_name:
                company_name = company_name[:company_name.find('HOLDING') - 1]
            if 'LABORATORIES' in company_name:
                company_name = company_name[:company_name.find('LABORATORIES') - 1]
            if ' AG' in company_name:
                company_name = company_name[:company_name.find(' AG')]
            if 'S.A' in company_name:
                company_name = company_name[:company_name.find('S.A') - 1]
            if ' SA' in company_name:
                company_name = company_name[:company_name.find(' SA')]
            if '.COM' in company_name:
                company_name = company_name[:company_name.find('.COM')]
            if 'N.V' in company_name:
                company_name = company_name[:company_name.find('N.V') - 1]
            if 'INDUSTRIES' in company_name:
                company_name = company_name[:company_name.find('INDUSTRIES') - 1]
            if 'TECHNOL' in company_name:
                company_name = company_name[:company_name.find('TECHNOL') - 1]
            if 'O.N' in company_name:
                company_name = company_name[:company_name.find('O.N') - 1]
            if 'GROUP' in company_name:
                company_name = company_name[:company_name.find('GROUP') - 1]
            if 'SOLUTION' in company_name:
                company_name = company_name[:company_name.find('SOLUTION') - 1]

            if len(company_name) is 0 or len(company_name) is 1 or (company_name in blacklist):
                continue
            elif company_name == 'AMERICAN':
                company_name = 'AMERICAN AIRLINES'
        except:
            continue

        company_name = ' ' + company_name
        company_names.append(company_name + ' ')
        company_names.append(company_name + '.')
        company_names.append(company_name + ',')

    company_names = list(dict.fromkeys(company_names))

    print('Company Names Successfully Parsed...')
    for idx, key in enumerate(company_names):
        A.add_word(key, idx)

    A.make_automaton()
    print('Automaton generated')
    return (company_names, A)



def retrieve_forbes_article_data(article, company_list, company_name_automaton):

    article.paragraphs = []

    browser.get((article.url))

    try:
        article_text_section = browser.find_element_by_xpath('//*[@id="article-container-0"]/div[2]/div[2]/article-body-container/div/div')
        article_paragraph_tags = article_text_section.find_elements_by_tag_name('p')
    except:
        return

    all_tickers = []

    for paragraph in article_paragraph_tags:

        if '[+]' in paragraph.text:
            continue
        tickers = []
        for end_index, idx in company_name_automaton.iter(paragraph.text.upper()):
            company_formatted = company_list[idx]
            company_formatted = company_formatted[1:]
            company_formatted = company_formatted[:-1]
            tickers.append(company_formatted)

        all_tickers.extend(tickers)
        article.paragraphs.append(Paragraph(paragraph.text, tickers))
        article.webpage_text = article.webpage_text + paragraph.text

    article.tickers = all_tickers
    article.tickers = list(dict.fromkeys(article.tickers))
    return article

#forbes_URLs = get_forbes_URLs()
#for article in forbes_URLs:
#    retrieve_forbes_article_data(article)
#    print(article.paragraphs)



article_list = get_forbes_articles()
new_article_list = []
companies = populate_companies()
companies_names_list = companies[0]
companies_automaton = companies[1]

app_tickers = []
for article in article_list:
    new_article = retrieve_forbes_article_data(article, companies_names_list, companies_automaton)
    app_tickers.extend(new_article.tickers)
    new_article.paragraphs = [p.toJson() for p in new_article.paragraphs]
    new_article_list.append(new_article.toJson())

app_tickers = list(dict.fromkeys(app_tickers))

json_obj = json.dumps({
'all_tickers': app_tickers,
'articles': new_article_list
})
print(type(json_obj))

articles_file = open(r"articles.json","a")
articles_file.write(json_obj)
articles_file.close()
