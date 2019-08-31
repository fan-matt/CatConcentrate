import React from 'react';
import { StyleSheet , Text , View , Image } from 'react-native';

import ImageButton from "./components/ImageButton.js"

const HAMBURGER_ICON = require('./assets/hamburgerMenu.png');
const GIFT_ICON = require('./assets/gift.png');

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.upperButtonRow}>
        <ImageButton icon={HAMBURGER_ICON}></ImageButton>
        <ImageButton icon={GIFT_ICON}></ImageButton>
      </View>

      <Text>Hello from React Native!</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  } ,
  upperButtonRow: {
    flex: 1 ,
    flexDirection: 'row' ,
    justifyContent: 'space-between' ,
  } ,
});
