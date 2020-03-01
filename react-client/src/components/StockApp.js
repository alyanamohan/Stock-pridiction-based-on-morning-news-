import React from 'react'

import StockList from 'components/StockList'

import Typograpgh from '@material-ui/core/Typography'
import { makeStyles } from '@material-ui/core/styles'

const useStyles = makeStyles(({ spacing, palette }) => ({
    root: {
        width: '100%',
        textAlign: 'center',
        alignContent: 'center',
        alignItems: 'center'
    }
}))

const StockApp = props => {
    const classes = useStyles()

    return (
        <div className={classes.root}>
            <StockList />
        </div>
    )
}

export default StockApp
