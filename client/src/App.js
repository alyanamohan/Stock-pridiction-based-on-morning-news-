import React from 'react'
import Header from './components/Header'
import StockList from './components/Stocklist'

const seedData = [
    {
        ticker: 'AAPL',
        name: 'Apple',
        confidence: 0.9,
        articles: [{ url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }]
    },
    {
        ticker: 'AMZN',
        name: 'Amazon',
        confidence: 0.9,
        articles: [{ url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }]
    }
]

const App = () => {
    return (
        <div className="App">
            <Header />
            <StockList tickers={seedData} />
        </div>
    )
}

export default App
