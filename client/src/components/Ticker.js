import React from 'react'
import { Accordion, Card } from 'react-bootstrap'
import 'styles/components/ticker.scss'
function Ticker(props) {
    const { stock } = props
    return (
        <div className="ticker">
            <Accordion defaultActiveKey="1">
                <Card>
                    <Card.Header>
                        <Accordion.Toggle as="a" eventKey="0">
                            <h3>
                                {stock.name} - {stock.ticker} - {stock.confidence}
                            </h3>
                        </Accordion.Toggle>
                    </Card.Header>
                    <Accordion.Collapse eventKey="0">
                        <Card.Body>Put stock info here/articles</Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion>
        </div>
    )
}

export default Ticker
