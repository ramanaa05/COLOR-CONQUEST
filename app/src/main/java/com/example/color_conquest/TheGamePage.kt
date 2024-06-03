package com.example.color_conquest

import android.media.MediaPlayer
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

var activatePowerUp = mutableStateOf(false)
var pbutton = mutableStateOf(true)
var incrTime = mutableStateOf(0)

@Composable
fun TheGamePage(navController: NavController){
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    if (toHome.intValue == 1){
        toHome.intValue = 0
        navController.navigate(Screen.MainPage.route)
    }

    if ((bestOf.intValue == 0) or (mode.intValue == 0)) bestOf.intValue = 1

    if((timeMinutes.intValue == 0) and (timeSeconds.intValue == 0)){
        timeMinutes.intValue = 1
        timeSeconds.intValue = 30
    }

    if (mode.intValue == 0){
        N.intValue = 5
    }

    createTile((N.intValue)*(N.intValue))
    createBelongsTO((N.intValue)*(N.intValue))
    Box(
        modifier = Modifier
            .background(currentColor.value)
            .fillMaxSize()
    ){
        //CLOSE BUTTON
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ){
            Button(
                onClick = { pageFlag.intValue = 3; pause.value = true },
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(25)),
                colors = ButtonDefaults.buttonColors(Color(0xfffffffd)),
            ) {
            }
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(16.dp),
                painter = painterResource(id = R.drawable.close),
                contentDescription = "Close"
            )
        }

        Card (
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 48.dp),
            shape = RoundedCornerShape(48.dp, 0.dp, 0.dp, 48.dp),
            border = BorderStroke(4.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color(0xff2f323b))
        ){
            Text(
                modifier = Modifier
                    .padding(end = 30.dp, start = 27.dp, top = 4.dp, bottom = 4.dp),
                color = Color(0xffff5f57),
                text = playerOnePoints.intValue.toString(),
                fontWeight = FontWeight(500),
                fontSize = 33.sp,
            )
        }
        Card (
            modifier = Modifier
                .padding(top = 48.dp),
            shape = RoundedCornerShape(0.dp, 48.dp, 48.dp, 0.dp),
            border = BorderStroke(4.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color(0xff2f323b))
        ){
            Text(
                modifier = Modifier
                    .padding(start = 30.dp, end = 27.dp, top = 4.dp, bottom = 4.dp)
                    .rotate(180f),
                color = Color(0xff2fb6f0),
                text = playerTwoPoints.intValue.toString(),
                fontWeight = FontWeight(500),
                fontSize = 33.sp,
            )
        }

        Card (
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 48.dp, end = 300.dp),
            shape = RoundedCornerShape(100),
            border = BorderStroke(4.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color(0xff2f323b))
        ){
            Text(
                modifier = Modifier
                    .padding(end = 30.dp, start = 27.dp, top = 4.dp, bottom = 4.dp),
                color = Color(0xffff5f57),
                text = playerOneWins.intValue.toString(),
                fontWeight = FontWeight(500),
                fontSize = 33.sp,
            )
        }
        Card (
            modifier = Modifier
                .padding(top = 48.dp, start = 300.dp),
            shape = RoundedCornerShape(100),
            border = BorderStroke(4.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color(0xff2f323b))
        ){
            Text(
                modifier = Modifier
                    .padding(start = 30.dp, end = 27.dp, top = 4.dp, bottom = 4.dp)
                    .rotate(180f),
                color = Color(0xff2fb6f0),
                text = playerTwoWins.intValue.toString(),
                fontWeight = FontWeight(500),
                fontSize = 33.sp,
            )
        }

        Card (
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 48.dp, end = 100.dp)
                .shadow(5.dp, CutCornerShape(0.dp, 40.dp, 40.dp, 0.dp))
                .clip(RoundedCornerShape(10.dp, 0.dp, 0.dp, 10.dp)),
            shape = CutCornerShape(0.dp, 40.dp, 40.dp, 0.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color(0xff2f323b))
        ){
            Text(
                modifier = Modifier
                    .padding(start = 18.dp, end = 40.dp, top = 7.dp, bottom = 7.dp),
                color = Color(0xffff5f57),
                text = playerOne.value.uppercase(),
                fontWeight = FontWeight(500),
                fontSize = 27.sp,
            )
        }
        Card (
            modifier = Modifier
                .padding(top = 48.dp, start = 100.dp)
                .shadow(10.dp, CutCornerShape(40.dp, 0.dp, 0.dp, 40.dp))
                .clip(RoundedCornerShape(0.dp, 10.dp, 10.dp, 0.dp)),
            shape = CutCornerShape(40.dp, 0.dp, 0.dp, 40.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color(0xff2f323b))
        ){
            Text(
                modifier = Modifier
                    .padding(start = 40.dp, end = 18.dp, top = 7.dp, bottom = 7.dp)
                    .rotate(180f),
                color = Color(0xff2fb6f0),
                text = playerTwo.value.uppercase(),
                fontWeight = FontWeight(500),
                fontSize = 27.sp,
            )
        }

        //POWER UP BUTTON
        var timeOne by remember {
            mutableStateOf((timeSeconds.intValue + (timeMinutes.intValue * 60))*1000)
        }
        var timeTwo by remember {
            mutableStateOf((timeSeconds.intValue + (timeMinutes.intValue * 60))*1000)
        }
        var totalTimeOne by remember {
            mutableStateOf((timeSeconds.intValue + (timeMinutes.intValue * 60))*1000)
        }
        var totalTimeTwo by remember {
            mutableStateOf((timeSeconds.intValue + (timeMinutes.intValue * 60))*1000)
        }

        if ((grantedTo.intValue == 1) ){
            if((grantedPowerUp.intValue == 1) or (grantedPowerUp.intValue == 3) and pbutton.value){
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 120.dp, end = 0.dp)
                ){
                    Button(
                        onClick = {
                            if ((grantedPowerUp.intValue == 1) and (currentPlayerNumber.intValue == 1)){
                                if(playerOneFirstTurn.intValue == 0){
                                    activatePowerUp.value = true
                                    pbutton.value = false
                                }
                            }
                            else if ((grantedPowerUp.intValue == 3) and (currentPlayerNumber.intValue == 1)){
                                activatePowerUp.value = true
                                pbutton.value = false
                            }
                        },
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7d141e))
                    ) {
                    }
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                            .rotate(inv),
                        painter = painterResource(id = power.value),
                        contentDescription = "random power-up"
                    )
                }
            }
            else if (grantedPowerUp.intValue == 2){
                if (incrTime.value < 1){
                    timeOne += 10000
                    totalTimeOne += 10000
                    incrTime.value += 1
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 120.dp, end = 0.dp)
                ){
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7d141e))
                    ) {
                    }
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                            .rotate(inv),
                        painter = painterResource(id = power.value),
                        contentDescription = "random power-up"
                    )
                }
            }
        }

        else if ((grantedTo.intValue == 2)){
            if((grantedPowerUp.intValue == 1) or (grantedPowerUp.intValue == 3) and pbutton.value){
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 120.dp, end = 0.dp)
                ){
                    Button(
                        onClick = {
                            if ((grantedPowerUp.intValue == 1) and (currentPlayerNumber.intValue == 2)){
                                if(playerTwoFirstTurn.intValue == 0){
                                    activatePowerUp.value = true
                                    pbutton.value = false
                                }
                            }
                            else if ((grantedPowerUp.intValue == 3) and (currentPlayerNumber.intValue == 2)){
                                activatePowerUp.value = true
                                pbutton.value = false
                            }
                        },
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff3a918c))
                    ) {
                    }
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                            .rotate(inv),
                        painter = painterResource(id = power.value),
                        contentDescription = "random power-up"
                    )
                }
            }
            else if (grantedPowerUp.intValue == 2){
                if(incrTime.value < 1){
                    timeTwo += 10000
                    totalTimeTwo += 10000
                    incrTime.value += 1
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 120.dp, end = 0.dp)
                ){
                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff3a918c))
                    ) {
                    }
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                            .rotate(inv),
                        painter = painterResource(id = power.value),
                        contentDescription = "random power-up"
                    )
                }
            }
        }

        //TIMER MODE CODE
        var running by remember {
            mutableStateOf(currentPlayerNumber.intValue)
        }
        if ((timeSeconds.intValue == 0) and (timeMinutes.intValue == 0)){
            timeSeconds.intValue = 30
            timeMinutes.intValue = 1
        }

        if (timedMode.value and ((mode.intValue == 1) or (mode.intValue == 2))){
            var valueOne by remember {
                mutableStateOf(1f)
            }
            var valueTwo by remember {
                mutableStateOf(1f)
            }
            if (!(pause.value)){
                LaunchedEffect(key1 = running, key2 = timeOne, key3 = timeTwo) {

                    if ((running == 1) and (timeOne > 0)){
                        delay(1000)
                        timeOne -= 1000
                        valueOne = timeOne.toFloat() / totalTimeOne.toFloat()
                    }
                    else if ((running == 2) and (timeTwo > 0)){
                        delay(1000)
                        timeTwo -= 1000
                        valueTwo = timeTwo.toFloat() / totalTimeTwo.toFloat()
                    }
                }
            }

            Box(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
            ){
                Canvas(modifier = Modifier) {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(x = 100f, y = 1850f),
                        end = Offset(x =800f, y = 1850f),
                        strokeWidth = 10.dp.toPx()
                    )
                    drawLine(
                        color = Color.White,
                        start = Offset(x = 100f, y = 1850f),
                        end = Offset(x = 100f + ((700f) * valueOne), y = 1850f),
                        strokeWidth = 10.dp.toPx()
                    )
                    drawPoints(
                        listOf(Offset(x = 100f + ((700f) * valueOne), y = 1850f)),
                        pointMode = PointMode.Points,
                        color = Color.White,
                        strokeWidth = (10.dp * 3f).toPx(),
                        cap = StrokeCap.Round
                    )
                }

                Canvas(
                    modifier = Modifier
                ) {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(x = 280f, y = 350f),
                        end = Offset(x = 980f, y = 350f),
                        strokeWidth = 10.dp.toPx()
                    )
                    drawLine(
                        color = Color.White,
                        start = Offset(x = 980f - (700f * valueTwo), y = 350f),
                        end = Offset(x = (980f), y = 350f),
                        strokeWidth = 10.dp.toPx()
                    )
                    drawPoints(
                        listOf(Offset(x = 980f - (700f * valueTwo), y = 350f)),
                        pointMode = PointMode.Points,
                        color = Color.White,
                        strokeWidth = (10.dp * 3f).toPx(),
                        cap = StrokeCap.Round
                    )
                }
                val family = FontFamily(
                    Font(R.font.digital)
                )

                Box(
                    modifier = Modifier
                        .offset(y = (-150).dp, x = (40).dp)
                        .align(Alignment.BottomStart)
                        .background(Color.Transparent)
                ){
                    Text(
                        modifier = Modifier
                            .padding(),
                        text = "${(timeOne/1000)/60}:${(timeOne/1000) - (((timeOne/1000)/60)*60)}",
                        color = Color.White,
                        fontSize = 45.sp,
                        fontFamily = family
                    )
                }
                Box(
                    modifier = Modifier
                        .offset(y = (150).dp, x = (-40).dp)
                        .rotate(180f)
                        .align(Alignment.TopEnd)
                        .background(Color.Transparent)
                ){
                    Text(
                        modifier = Modifier
                            .padding(),
                        text = "${(timeTwo/1000)/60}:${(timeTwo/1000) - (((timeTwo/1000)/60)*60)}",
                        color = Color.White,
                        fontSize = 45.sp,
                        fontFamily = family
                    )
                }
            }
        }

        val pop = MediaPlayer.create(context, R.raw.pop)
        val buzz = MediaPlayer.create(context, R.raw.buzz)
        //THE GAME GRID
        LazyVerticalGrid(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
                .align(Alignment.Center),
            columns = GridCells.Fixed(N.intValue),
            content = {
                items(count = (N.intValue)*(N.intValue)){
                    Box(
                        modifier = Modifier
                    ){
                        if(setTime.value){
                            timeOne = (timeSeconds.intValue + (timeMinutes.intValue * 60))*1000
                            timeTwo = (timeSeconds.intValue + (timeMinutes.intValue * 60))*1000
                            setTime.value = false
                            running = 1
                        }
                        if (currentPlayerNumber.intValue == 1){
                            Button(
                                onClick = {
                                    if ((playerOneFirstTurn.intValue == 1) or ((activatePowerUp.value) and (grantedPowerUp.intValue == 1) and (grantedTo.intValue == 1) and (belongsTo[it] != 2))){
                                        if(mode.intValue == 2) pop.start()
                                        tile[it] = 3
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        playerOneFirstTurn.intValue = 0
                                        currentPlayerNumber.intValue = 2
                                        running = 2
                                        currentColor.value = Color(0xff2fb6f0)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xffff5f57)
                                            currentPlayerNumber.intValue = 1
                                            running = 1
                                        }
                                        if((activatePowerUp.value) and (grantedPowerUp.intValue == 1)) activatePowerUp.value = false
                                    }

                                    else if(belongsTo[it] == 1){
                                        if(mode.intValue == 2) pop.start()
                                        tile[it] += 1
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        playerOneFirstTurn.intValue = 0
                                        currentPlayerNumber.intValue = 2
                                        running = 2
                                        currentColor.value = Color(0xff2fb6f0)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xffff5f57)
                                            currentPlayerNumber.intValue = 1
                                            running = 1
                                        }
                                    }
                                    else{
                                        if (mode.intValue == 2) buzz.start()
                                    }
                                    modifyTile(N.intValue)
                                },
                                modifier = Modifier
                                    .padding(5.dp)
                                    .aspectRatio(1f)
                                    .shadow(5.dp, RoundedCornerShape(14.dp))
                                    .align(Alignment.Center),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff5e5ce))
                            ){
                            }
                        }
                        else if (currentPlayerNumber.intValue == 2){
                            Button(
                                onClick = {
                                    if(((playerTwoFirstTurn.intValue == 1) and (belongsTo[it] != 1)) or ((activatePowerUp.value) and (grantedPowerUp.intValue == 1) and (grantedTo.intValue == 2) and (belongsTo[it] != 1))){
                                        if(mode.intValue == 2) pop.start()
                                        tile[it] = 3
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        playerTwoFirstTurn.intValue = 0
                                        currentPlayerNumber.intValue = 1
                                        running = 1
                                        currentColor.value = Color(0xffff5f57)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xff2fb6f0)
                                            currentPlayerNumber.intValue = 2
                                            running = 2
                                        }
                                        if((activatePowerUp.value) and (grantedPowerUp.intValue == 1)) activatePowerUp.value = false
                                    }
                                    else if(belongsTo[it] == 2){
                                        if(mode.intValue == 2) pop.start()
                                        tile[it] += 1
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        currentPlayerNumber.intValue = 1
                                        running = 1
                                        currentColor.value = Color(0xffff5f57)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xff2fb6f0)
                                            currentPlayerNumber.intValue = 2
                                            running = 2
                                        }
                                    }
                                    else{
                                        if (mode.intValue == 2) buzz.start()
                                    }
                                    modifyTile(N.intValue)
                                },
                                modifier = Modifier
                                    .padding(5.dp)
                                    .aspectRatio(1f)
                                    .shadow(5.dp, RoundedCornerShape(14.dp))
                                    .align(Alignment.Center),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff5e5ce))
                            ){
                            }
                        }

                        //CHECK IF THERE IS A WINNER
                        if(((playerOneFirstTurn.intValue == 0) and (playerTwoFirstTurn.intValue == 0) and (!belongsTo.contains(1) or !belongsTo.contains(2))) or ((timeOne <= 0) or (timeTwo <= 0))){
                            incrTime.value = 0
                            if((grantedPowerUp.intValue == 2) and (grantedTo.intValue ==1)) totalTimeOne -= 10000
                            else if((grantedPowerUp.intValue == 2) and (grantedTo.intValue ==2)) totalTimeTwo -= 10000
                            pbutton.value = true
                            updateHighScore(preferencesManager, if (winner.value == playerOne.value.uppercase()) playerOne.value.uppercase() else playerTwo.value.uppercase(), if (winner.value == playerOne.value.uppercase()) playerOnePoints.intValue else playerTwoPoints.intValue)
                            if (belongsTo.contains(1) or (timeTwo <= 0)){
                                if (playerOneWins.intValue == (bestOf.intValue+1)/2) {
                                    winner.value = playerOne.value.uppercase()
                                }
                                else{
                                    currentLoss.intValue = 2
                                    playerOneWins.intValue += 1
                                    timeOne = (timeSeconds.intValue + (timeMinutes.intValue * 60))*1000
                                    timeTwo = (timeSeconds.intValue + (timeMinutes.intValue * 60))*1000
                                    running = 1
                                }
                                pause.value = true
                                setTime.value = true
                                pageFlag.intValue = 5
                            }
                            else{
                                if (playerTwoWins.intValue == (bestOf.intValue+1)/2) {
                                    winner.value = playerTwo.value.uppercase()
                                }
                                else {
                                    currentLoss.intValue = 1
                                    playerTwoWins.intValue += 1
                                    timeOne = (timeSeconds.intValue + (timeMinutes.intValue * 60))*1000
                                    timeTwo = (timeSeconds.intValue + (timeMinutes.intValue * 60))*1000
                                    running = 1
                                }
                                pause.value = true
                                setTime.value = true
                                pageFlag.intValue = 5
                            }

                            if ((playerOneWins.intValue == (bestOf.intValue+1)/2) or (playerTwoWins.intValue == (bestOf.intValue+1)/2)){
                                if (playerOneWins.intValue == (bestOf.intValue+1)/2){
                                    winner.value = playerOne.value.uppercase()
                                }
                                else{
                                    winner.value = playerTwo.value.uppercase()
                                }
                                pageFlag.intValue = 2
                                pause.value = true

                                if (winner.value == playerOne.value.uppercase()){
                                    currentColor.value = Color(0xffff5f57)
                                }
                                else{
                                    currentColor.value = Color(0xff2fb6f0)
                                }
                            }
                            else{
                                reset()
                            }
                        }

                        val radius by animateIntAsState(
                            targetValue = if(tile[it] != 0) (89 - ((N.intValue) * (N.intValue))) else 0,
                            label = ""
                        )
                        if(belongsTo[it] == 1){
                            Image(
                                modifier = Modifier
                                    .size((radius).dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.red_button),
                                contentDescription = "Red background"
                            )
                        }
                        else if (belongsTo[it] == 2){
                            Image(
                                modifier = Modifier
                                    .size((radius).dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.blue_button),
                                contentDescription = "Blue background"
                            )
                        }
                        if (tile[it] != 0) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                text = tile[it].toString(),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 24.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        )
    }
}