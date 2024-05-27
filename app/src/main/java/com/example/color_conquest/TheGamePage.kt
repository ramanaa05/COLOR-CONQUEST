package com.example.color_conquest

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

var activatePowerUp = mutableStateOf(false)
var pbutton = mutableStateOf(true)
@Composable
fun TheGamePage(navController: NavController){
    if (toHome.intValue == 1){
        toHome.intValue = 0
        navController.navigate(Screen.MainPage.route)
    }
    if ((bestOf.intValue == 0) or (mode.intValue == 0)) bestOf.intValue = 1

    createTile((N.intValue)*(N.intValue))
    createBelongsTO((N.intValue)*(N.intValue))
    Box(
        modifier = Modifier
            .background(currentColor.value)
            .fillMaxSize()
    ){

        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ){
            Button(
                onClick = { pageFlag.intValue = 3 },
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
        if ((grantedTo.intValue == 1) and pbutton.value){
            if((grantedPowerUp.intValue == 1) or (grantedPowerUp.intValue == 3)){
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
        }

        else if ((grantedTo.intValue == 2) and pbutton.value){
            if((grantedPowerUp.intValue == 1) or (grantedPowerUp.intValue == 3)){
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
        }

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
                        if (currentPlayerNumber.intValue == 1){
                            Button(
                                onClick = {
                                    if ((playerOneFirstTurn.intValue == 1) or ((activatePowerUp.value) and (grantedPowerUp.intValue == 1) and (grantedTo.intValue == 1) and (belongsTo[it] != 2))){
                                        tile[it] = 3
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        playerOneFirstTurn.intValue = 0
                                        currentPlayerNumber.intValue = 2
                                        currentColor.value = Color(0xff2fb6f0)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xffff5f57)
                                            currentPlayerNumber.intValue = 1
                                        }
                                        if((activatePowerUp.value) and (grantedPowerUp.intValue == 1)) activatePowerUp.value = false
                                    }

                                    else if(belongsTo[it] == 1){
                                        tile[it] += 1
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        playerOneFirstTurn.intValue = 0
                                        currentPlayerNumber.intValue = 2
                                        currentColor.value = Color(0xff2fb6f0)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xffff5f57)
                                            currentPlayerNumber.intValue = 1
                                        }
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
                                        tile[it] = 3
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        playerTwoFirstTurn.intValue = 0
                                        currentPlayerNumber.intValue = 1
                                        currentColor.value = Color(0xffff5f57)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xff2fb6f0)
                                            currentPlayerNumber.intValue = 2
                                        }
                                        if((activatePowerUp.value) and (grantedPowerUp.intValue == 1)) activatePowerUp.value = false
                                    }
                                    else if(belongsTo[it] == 2){
                                        tile[it] += 1
                                        belongsTo[it] = currentPlayerNumber.intValue
                                        currentPlayerNumber.intValue = 1
                                        currentColor.value = Color(0xffff5f57)
                                        if ((grantedPowerUp.intValue == 3) and (activatePowerUp.value)){
                                            activatePowerUp.value = false
                                            currentColor.value = Color(0xff2fb6f0)
                                            currentPlayerNumber.intValue = 2
                                        }
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
                        if((playerOneFirstTurn.intValue == 0) and (playerTwoFirstTurn.intValue == 0) and (!belongsTo.contains(1) or !belongsTo.contains(2))){
                            pbutton.value = true
                            if (belongsTo.contains(1)){
                                if (playerOneWins.intValue == (bestOf.intValue+1)/2) {
                                    winner.value = playerOne.value.uppercase()
                                }
                                else{
                                    playerOneWins.intValue += 1
                                    currentLoss.intValue = 2
                                }
                                pageFlag.intValue = 5
                            }
                            else{
                                if (playerTwoWins.intValue == (bestOf.intValue+1)/2) {
                                    winner.value = playerTwo.value.uppercase()
                                }
                                else {
                                    playerTwoWins.intValue += 1
                                    currentLoss.intValue = 1
                                }
                                pageFlag.intValue = 5
                            }

                            if ((playerOneWins.intValue == (bestOf.intValue+1)/2) or (playerTwoWins.intValue == (bestOf.intValue+1)/2)){
                                pageFlag.intValue = 2

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