import React from 'react'
import 'styles/components/ticker.scss'

import { makeStyles } from '@material-ui/core/styles'
import { Card, CardActionArea, CardActions, CardContent } from '@material-ui/core/'
import ArrowUpwardIcon from '@material-ui/icons/ArrowUpward'
import ArrowDownwardIcon from '@material-ui/icons/ArrowDownward'
import Typography from '@material-ui/core/Typography'
import Button from '@material-ui/core/Button'

const useStyles = makeStyles({
    actions: {
        textAlign: 'center'
    },
    title: {
        alignItems: 'center',
        verticalAlign: 'middle'
    }
})

function Ticker(props) {
    const { stock } = props
    const classes = useStyles()

    return (
        <>
            <Card className={classes.root}>
                <CardActionArea>
                    <CardContent>
                        <Typography variant="h5" component="h2" className={classes.title}>
                            {stock.ticker} - <ArrowUpwardIcon />
                        </Typography>
                        <Typography variant="body2" component="p">
                            {stock.name} - Positive 90%
                        </Typography>
                        {/* <Typography variant="h5" component="h2">
                            - 
                            <ArrowUpwardIcon />
                        </Typography> */}
                    </CardContent>
                </CardActionArea>
                <CardActions className={classes.actions}>
                    <Button size="small" color="primary">
                        Articles
                    </Button>
                    <Button size="small" color="primary">
                        Invest
                    </Button>
                </CardActions>
            </Card>
        </>
    )
}

export default Ticker

{
    /* <Chip label={`${stock.ticker}  -  ${stock.name}`} />
            <Accordion defaultActiveKey="1">
                <Card>
                    <Card.Header>
                        <Accordion.Toggle as="a" eventKey="0">
                            <h3>- {stock.confidence}</h3>
                        </Accordion.Toggle>
                    </Card.Header>
                    <Accordion.Collapse eventKey="0">
                        <Card.Body>Put stock info here/articles</Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion> */
}
