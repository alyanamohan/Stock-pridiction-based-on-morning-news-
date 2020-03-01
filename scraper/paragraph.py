import json

class Paragraph:

    def __init__(self, text, tickers):
        self.text = text
        self.tickers = tickers

    def toJson(self):
        return json.dumps({
            "text": self.text,
            "tickers": self.tickers
        })
