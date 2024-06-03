package com.example.color_conquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.color_conquest.ui.theme.Color_conquestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Color_conquestTheme(darkTheme = darkTheme.value) {
                remember {
                    playerTwo
                    playerOne
                    currentColor
                    colorBit
                    currentPlayer
                    playerOnePoints
                    playerTwoPoints
                    tile
                    winner
                }

                // A surface container using the 'background' color from the theme
                Navigation()
                if (pageFlag.intValue == 1){
                    HelpBox()
                }
                else if(pageFlag.intValue == 2){
                    WinnerPage()
                }
                else if(pageFlag.intValue == 3){
                    CloseButton()
                }
                else if(pageFlag.intValue == 4){
                    HighScore()
                }
                else if (pageFlag.intValue == 5){
                    PowerUps()
                    if (poweInfo.value){
                        PowerupInfo()
                    }
                }
            }
        }
    }
}