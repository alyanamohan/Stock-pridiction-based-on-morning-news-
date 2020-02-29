import React, { useState, useEffect } from 'react'
import Ticker from './Ticker'
import 'styles/components/stocklist.scss'

import Paper from '@material-ui/core/Paper'
import Grid from '@material-ui/core/Grid'
import Typography from '@material-ui/core/Typography'

import { makeStyles } from '@material-ui/core/styles'

const useStyles = makeStyles(({ spacing, palette }) => ({
    root: {
        flexGrow: 1
    },
    paper: {
        padding: spacing(2),
        textAlign: 'center',
        color: palette.text.secondary
    },
    centerer: {
        position: 'absolute',
        left: '50%',
        top: '50%',
        transform: 'translate(-50%, -50%)'
    }
}))

const Stocklist = props => {
    const [date, setDate] = useState(null)
    const classes = useStyles()

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
            <div className={classes.centerer}>
                <div className={classes.root}>
                    <Grid container spacing={3}>
                        <Grid item xs stretch>
                            <Paper className={classes.paper}>
                                <Typography>
                                    Stock predictions for {date.getMonth()} / {date.getDate()} /{' '}
                                    {date.getFullYear()}
                                </Typography>
                            </Paper>
                        </Grid>
                        <Grid item xs>
                            <Paper className={classes.paper}>
                                {tickers.map(stock => (
                                    <Ticker stock={stock} key={stock} />
                                ))}
                            </Paper>
                        </Grid>
                    </Grid>
                </div>
            </div>
        )
    )
}

export default Stocklist
