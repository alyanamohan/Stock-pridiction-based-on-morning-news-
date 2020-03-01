import React from 'react'
import 'styles/components/header.scss'
import Logo from 'assets/logo.gif'

import { makeStyles } from '@material-ui/core/styles'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Typography from '@material-ui/core/Typography'
import Avatar from '@material-ui/core/Avatar'
import Box from '@material-ui/core/Box'

const useStyles = makeStyles(({ spacing }) => ({
    root: {
        flexGrow: 1
    },
    menuButton: {
        marginRight: spacing(2)
    },

    logo: {
        marginRight: spacing(2)
    },
    title: {
        textAlign: 'center',
        paddingTop: spacing(3),
        fontWeight: '900'
    },
    line: {
        width: '80%',
        borderTop: '10px solid black'
    }
}))

const Header = props => {
    const classes = useStyles()

    return (
        <>
            <Box display="flex" alignItems="center" justifyContent="center">
                <Avatar alt="Remy Sharp" src={Logo} className={classes.logo} />
                <Typography variant="h2" className={classes.title}>
                    IntelliVast
                </Typography>
            </Box>
        </>
    )
}

export default Header
