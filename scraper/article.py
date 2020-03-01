import json


class Article:

    def __init__(self, url, headline, weight, webpage_text="", tickers="", paragraphs=[]):
        self.webpage_text = webpage_text
        self.tickers = tickers
        self.url = url
        self.headline = headline
        self.paragraphs = paragraphs
        self.weight = weight

    def toJson(self):
        return json.dumps({
            "text": self.webpage_text,
            "tickers": self.tickers,
            "url": self.url,
            "headline": self.headline,
            "paragraphs": self.paragraphs,
            "weight": self.weight
        })

    def toObj(self):
        return {
            "text": self.webpage_text,
            "tickers": self.tickers,
            "url": self.url,
            "headline": self.headline,
            "paragraphs": self.paragraphs,
            "weight": self.weight
        }
