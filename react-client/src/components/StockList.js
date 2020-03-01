import React from 'react'

import { makeStyles, Card, CardContent, Typography } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import TrendingUpSharpIcon from '@material-ui/icons/TrendingUpSharp'
import Paper from '@material-ui/core/Paper'
import Box from '@material-ui/core/Box'
import StockInfo from 'components/StockInfo'

const seedData = [
    {
        symbol: 'AAPL',
        name: 'Apple',
        currency: 'USD',
        price: 200.52,
        confidence: 0.9,
        trend: 0.8
    },
    {
        symbol: 'AMD',
        name: 'AMD',
        currency: 'USD',
        price: 43.52,
        confidence: 1,
        trend: 0.45
    },
    {
        symbol: 'XOM',
        name: 'Exxon Mobil',
        currency: 'USD',
        price: 95.52,
        confidence: 0.9,
        trend: 0.6
    },
    {
        symbol: 'INDEXSP',
        name: 'S&P 500 Index',
        currency: 'USD',
        price: 2954.22,
        confidence: 0.51,
        trend: 0.3
    },
    {
        symbol: 'NASDAQ',
        name: 'NASDAQ',
        currency: 'USD',
        price: 8567.37,
        confidence: 1,
        trend: 0.4
    },
    {
        symbol: 'DJI',
        name: 'Dow Jones',
        currency: 'USD',
        price: 25409.36,
        confidence: 0.8,
        trend: 0.65
    },
    {
        symbol: 'MSFT',
        name: 'Microsoft Corporation',
        currency: 'USD',
        price: 162.01,
        confidence: 0.9,
        trend: 0.54
    },
    {
        symbol: 'AMZN',
        name: 'Amazon.com, Inc',
        currency: 'USD',
        price: 1883.75,
        confidence: 0.9,
        trend: 0.6
    }
]

const useStyles = makeStyles(({ spacing, palette }) => ({
    root: {
        flexGrow: 1,
        padding: spacing(2)
    },
    paper: {
        padding: spacing(2),
        textAlign: 'center',
        color: palette.text.secondary
    },
    bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)'
    },
    title: {
        fontSize: 14
    },
    pos: {
        marginBottom: 12
    },
    cards: {
        opacity: 0.7
    },
    grid: {
        marginTop: spacing(2),
        marginBottom: spacing(2),
        gridGap: spacing(3, 0)
    },
    headers: {
        marginLeft: spacing(3),
        textAlign: 'left'
    }
}))

const StockList = props => {
    const classes = useStyles()

    return (
        <div className={classes.root}>
            <Typography variant="h4" className={classes.headers}>
                Buy
            </Typography>
            <hr />

            <Grid container alignItems="center" alignContent="center" spacing={3} className={classes.grid}>
                {seedData
                    .sort((a, b) => a.trend < b.trend)
                    .slice(0, 8)
                    .map(stock => (
                        <>
                            {stock.trend > 0.5 && (
                                <Grid item xs={6} lg={3}>
                                    <StockInfo stock={stock} />
                                </Grid>
                            )}
                        </>
                    ))}
            </Grid>

            <Typography variant="h4" className={classes.headers}>
                Sell
            </Typography>
            <hr />

            <Grid container alignItems="center" alignContent="center" spacing={3} className={classes.grid}>
                {seedData
                    .sort((a, b) => a.trend > b.trend)
                    .slice(0, 8)
                    .reverse()
                    .map(stock => (
                        <>
                            {stock.trend < 0.5 && (
                                <Grid item xs={6} lg={3}>
                                    <StockInfo stock={stock} />
                                </Grid>
                            )}
                        </>
                    ))}
            </Grid>
        </div>
    )
}

export default StockList
