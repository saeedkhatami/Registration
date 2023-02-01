import React, { Component } from 'react'

class FooterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <footer className = "footer">
                    <span className="text-muted">Copyright © 2022 · Hosted on Cloudways · Sitemap</span>
                </footer>
            </div>
        )
    }
}

export default FooterComponent
