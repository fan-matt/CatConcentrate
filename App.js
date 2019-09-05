"use strict";

import React from 'react';
import { StyleSheet , Dimensions , View , Image , ImageBackground } from 'react-native';

import images from './assets/imguri.json';

import ImageEditor from "@react-native-community/image-editor";


import ImageButton from "./components/ImageButton.js"

const ITEMS_BACKGROUND = require('./assets/itemsBackground.png');
const REPEAT_BACKGROUND = require('./assets/repeatingBackground.png');
const HAMBURGER_ICON = require('./assets/hamburgerMenu.png');
const GIFT_ICON = require('./assets/gift.png');

export default function App() {
  return (
    <ImageBackground
      source={{uri: images.background}}
      style={styles.background}
      imageStyle={styles.backgroundImg}
    >

      <View style={styles.upperButtonRow}>  
        <ImageButton icon={HAMBURGER_ICON}></ImageButton>
        <ImageButton icon={GIFT_ICON}></ImageButton>
      </View>      
    </ImageBackground>
  );
}

const styles = StyleSheet.create({
  background: {
    position: 'relative' ,
    width: Dimensions.get('window').width ,
    height: Dimensions.get('window').height ,
    flex: 1 ,
    // flexDirection: 'row' ,
    // justifyContent: "center",
    // alignItems: "center" ,
  } ,
  backgroundImg: {
    position: 'absolute' ,
    left: 0 ,
    resizeMode: 'contain' ,
  } ,
  upperButtonRow: {
    flex: 1 ,
    flexDirection: 'row' ,
    justifyContent: 'space-between' ,
  } ,
});
