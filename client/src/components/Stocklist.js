import React, { useState, useEffect } from 'react'
import Ticker from './Ticker'
import 'styles/components/stocklist.scss'
import { Jumbotron, Button } from 'react-bootstrap'
function Stocklist(props) {
    const [date, setDate] = useState(null)

    useEffect(() => {
        if (!date) {
            setDate(new Date())
        }
    }, [date])

    // * Grab ticker array from props
    const { tickers } = props

    // * Render stock list
    return (
        date && (
            <div className="stocklist">
                <Jumbotron>
                    <h1>
                        Stock predictions for {date.getMonth()} / {date.getDate()} /{' '}
                        {date.getFullYear()}
                    </h1>
                </Jumbotron>
                <div className="list">
                    {tickers.map(stock => {
                        return <Ticker stock={stock} />
                    })}
                </div>
            </div>
        )
    )
}

export default Stocklist
