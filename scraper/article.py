import json


class Article:

    def __init__(self, webpage_text, ticker, url, headline):
        self.webpage_text = webpage_text
        self.ticker = ticker
        self.url = url
        self.headline = headline

    def toJson(self):
        return json.dumps({
            "text": self.webpage_text,
            "ticker": self.ticker,
            "url": self.url
        })
