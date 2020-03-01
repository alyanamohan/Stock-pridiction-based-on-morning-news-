import React from 'react'
import 'styles/components/header.scss'
import Logo from 'assets/logo.gif'
function Header(props) {
    return (
        <div className="header">
            <span>
                <img src={Logo} />
                <p>Intellivast</p>
            </span>
        </div>
    )
}

export default Header
