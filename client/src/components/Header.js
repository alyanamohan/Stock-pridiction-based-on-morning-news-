import React from 'react'
import 'styles/components/header.scss'
import Logo from 'assets/logo.gif'

import { makeStyles } from '@material-ui/core/styles'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Typography from '@material-ui/core/Typography'
import Avatar from '@material-ui/core/Avatar'

const useStyles = makeStyles(({ spacing }) => ({
    root: {
        flexGrow: 1
    },
    menuButton: {
        marginRight: spacing(2)
    },
    title: {
        flexGrow: 1
    },
    logo: {
        marginRight: spacing(2)
    }
}))

const Header = props => {
    const classes = useStyles()

    return (
        <AppBar position="static">
            <Toolbar>
                <Avatar alt="Remy Sharp" src={Logo} className={classes.logo} />
                <Typography variant="h5" className={classes.title}>
                    Intellivast
                </Typography>
            </Toolbar>
        </AppBar>
    )
}

export default Header
