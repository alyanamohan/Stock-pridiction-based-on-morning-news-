from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from article import Article
from ticker import Ticker

browser = webdriver.Chrome('/usr/local/bin/chromedriver')
