package com.example.color_conquest

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

val N = mutableIntStateOf(5)
val pageFlag = mutableIntStateOf(0)
val toHome = mutableIntStateOf(0)
val playerOne = mutableStateOf("")
val playerOneFirstTurn = mutableIntStateOf(1)
val playerTwoFirstTurn = mutableIntStateOf(1)
val playerTwo = mutableStateOf("")
val currentColor = mutableStateOf(Color(0xffff5f57))
val colorBit = mutableIntStateOf(0)
val currentPlayer = mutableStateOf(playerOne.value)
val currentPlayerNumber = mutableIntStateOf(1)
val playerOnePoints = mutableIntStateOf(0)
val playerTwoPoints = mutableIntStateOf(0)
val tile = mutableStateListOf<Int>()
val belongsTo = mutableStateListOf<Int>()
val winner = mutableStateOf("")
val mode = mutableIntStateOf(0)
val bestOf = mutableIntStateOf(0)
val playerOneWins = mutableIntStateOf(0)
val playerTwoWins = mutableIntStateOf(0)
val darkTheme = mutableStateOf(false)
val currentLoss = mutableIntStateOf(0)
val poweInfo = mutableStateOf(false)
val grantedPowerUp = mutableIntStateOf(0)
val grantedTo = mutableIntStateOf(0)
val timedMode = mutableStateOf(false)
val timeMinutes = mutableIntStateOf(0)
val timeSeconds = mutableIntStateOf(0)
val setTime = mutableStateOf(false)
val pause = mutableStateOf(false)