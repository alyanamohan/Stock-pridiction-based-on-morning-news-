import json


class Article:

    def __init__(self, url, headline, weight, webpage_text="", tickers=[], paragraphs=[]):
        self.webpage_text = webpage_text
        self.tickers = tickers
    def __init__(self, url, headline, weight, webpage_text="", ticker="", paragraphs=[]):
        self.webpage_text = webpage_text
        self.ticker = ticker
        self.url = url
        self.headline = headline
        self.paragraphs = paragraphs
        self.weight = weight

    def toJson(self):
        return json.dumps({
            "text": self.webpage_text,
            "tickers": self.tickers,
            "ticker": self.ticker,
            "url": self.url,
            "headline": self.headline,
            "paragraphs": self.paragraphs
        })

    def toObj(self):
        return {
            "text": self.webpage_text,
            "tickers": self.tickers,
            "ticker": self.ticker,
            "url": self.url,
            "headline": self.headline,
            "paragraphs": self.paragraphs
        }
