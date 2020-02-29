# DEPENDENCIES
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from article import Article
from ticker import Ticker

browser = webdriver.Chrome('./chromedriver')


def get_cnn_shit():

    page = browser.get(('https://www.cnn.com/business'))
    container = browser.find_element_by_xpath(
        '//*[@id="business-zone-1"]/div[2]/div/div[1]/ul')

    articles = container.find_elements_by_class_name(
        'cd__content')

    for article in articles:
        link = article.find_element_by_tag_name(
            'a')
        # * Grab url and headline
        url = link.get_attribute("href")
        headline = link.find_element_by_class_name("cd__headline-text")


get_cnn_shit()
