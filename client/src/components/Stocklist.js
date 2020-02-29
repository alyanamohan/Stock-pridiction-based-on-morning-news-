import React from 'react'

import { makeStyles, Card, CardContent, Typography } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import Paper from '@material-ui/core/Paper'

const seedData = [
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    },
    {
        symbol: 'ITNL',
        name: 'Intel Corporation',
        currency: 'USD',
        price: 55.52,
        trend: 0.9,
        articles: [
            { url: 'https://forbes.com', title: 'Apple is sick', weight: 1.0 }
        ]
    }
]

const useStyles = makeStyles(({ spacing, palette }) => ({
    root: {
        flexGrow: 1
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
    }
}))

const StockList = props => {
    const classes = useStyles()

    return (
        <div className={classes.root}>
            <Grid container spacing={3} justify="center">
                {seedData.map(stock => (
                    <Grid item xs={3}>
                        <Card>
                            <CardContent>
                                <Typography className={classes.title}>
                                    {stock.name} - {stock.symbol}
                                </Typography>
                                <Typography variant="h5" component="h2">
                                    {stock.trend > 0.5 ? (
                                        <div>Arrow Up</div>
                                    ) : (
                                        <div>Arrow Down</div>
                                    )}
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>
                ))}
            </Grid>
        </div>
    )
}

export default StockList
