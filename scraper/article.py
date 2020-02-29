import json


class Article:

<<<<<<< HEAD
    def __init__(self, url, headline, weight, webpage_text="", tickers=[], paragraphs=[]):
        self.webpage_text = webpage_text
        self.tickers = tickers
=======
    def __init__(self, url, headline, weight, webpage_text="", ticker="", paragraphs=[]):
        self.webpage_text = webpage_text
        self.ticker = ticker
>>>>>>> refs/remotes/origin/feature/scraper
        self.url = url
        self.headline = headline
        self.paragraphs = paragraphs
        self.weight = weight

    def toJson(self):
        return json.dumps({
            "text": self.webpage_text,
<<<<<<< HEAD
            "tickers": self.tickers,
=======
            "ticker": self.ticker,
>>>>>>> refs/remotes/origin/feature/scraper
            "url": self.url,
            "headline": self.headline,
            "paragraphs": self.paragraphs
        })

    def toObj(self):
        return {
            "text": self.webpage_text,
<<<<<<< HEAD
            "tickers": self.tickers,
=======
            "ticker": self.ticker,
>>>>>>> refs/remotes/origin/feature/scraper
            "url": self.url,
            "headline": self.headline,
            "paragraphs": self.paragraphs
        }
