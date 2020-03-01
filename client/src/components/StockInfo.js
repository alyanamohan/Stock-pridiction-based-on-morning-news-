import React from 'react'

import { Box, Paper, Grid, Typography } from '@material-ui/core'
import { makeStyles } from '@material-ui/core/styles'

import TrendingUpSharpIcon from '@material-ui/icons/TrendingUpSharp'
import TrendingDownSharpIcon from '@material-ui/icons/TrendingDownSharp'

const useStyles = makeStyles(({ spacing, palette }) => ({
    root: {
        flexGrow: 1,
        alignItems: 'center'
    },
    paper: {
        padding: spacing(1),
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
    flex: {
        flex: 1
    },
    green: {
        color: '#00ff00'
    },
    red: {
        color: '#ff0000'
    },
    iconGrid: {
        alignContent: 'space-around',
        justifyContent: 'space-around',
        alignItems: 'space-around',
        justifyItems: 'space-around'
    }
}))

const StockInfo = props => {
    const { stock } = props
    const { trend } = stock
    const classes = useStyles()

    return (
        <Paper className={classes.cards}>
            <Grid container spacing={3} className={classes.root}>
                <Grid item xs={4} className={classes.iconGrid}>
                    {trend > 0.5 ? (
                        <TrendingUpSharpIcon fontSize="large" />
                    ) : (
                        <TrendingDownSharpIcon fontSize="large" />
                    )}
                </Grid>
                <Grid item>
                    <Typography variant="h6">{stock.name}</Typography>
                    <Box
                        display="flex"
                        className={classes.flex}
                        alignItems="center"
                        alignContent="space-between"
                        justifyItems="space-between"
                        justifyContent="space-between"
                    >
                        <Typography variant="h4" className={trend > 0.5 ? classes.green : classes.red}>
                            <b>{stock.symbol}</b>
                        </Typography>
                        <Typography variant="h5" className={trend > 0.5 ? classes.green : classes.red}>
                            {stock.trend * 100.0}%
                        </Typography>
                    </Box>
                </Grid>
            </Grid>
        </Paper>
    )
}

export default StockInfo
