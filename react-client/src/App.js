import React from 'react'
import Header from './components/Header'
import StockApp from './components/StockApp'

import 'styles/App.scss'

const App = () => {
    return (
        <div className="App">
            <Header />
            <StockApp />
        </div>
    )
}

export default App
