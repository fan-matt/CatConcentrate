"use strict";

import React , {Component} from "react";
import {AppRegistry , TouchableOpacity , Image} from "react-native";

export default class ImageButton extends Component {
    render() {
        return (
            <TouchableOpacity>
                <Image 
                    source={this.props.icon}
                />
            </TouchableOpacity>
        );
    }
}

AppRegistry.registerComponent('CatConcentrate', () => ImageButton);