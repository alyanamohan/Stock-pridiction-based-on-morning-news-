import requests
import json


class Ticker:

    # http://d.yimg.com/autoc.finance.yahoo.com/autoc?query=AAPL&lang=en
    def __init__(self, symbol='', name=''):

        self.name = name
        self.symbol = symbol

        #! INVALID: Make sure both aren't empty
        if symbol == '' and name == '':
            raise 'Error'

        # ? Get company name/ticker as needed
        if symbol == '' or name == '':
            res = requests.get(
                url='http://d.yimg.com/autoc.finance.yahoo.com/autoc',
                params={'lang': 'en',
                        'query': symbol if symbol != '' else name}
            )

            data = json.loads(str(res.json()).replace("\'", "\""))

            try:
                self.name = data['ResultSet']['Result'][0]['name']
                self.symbol = data['ResultSet']['Result'][0]['symbol']
            except ValueError:
                raise "Invalid Result"

        self.urls = []
