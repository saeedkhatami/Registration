import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-custom">
                    <div><a className="navbar-brand">Student Registration</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
