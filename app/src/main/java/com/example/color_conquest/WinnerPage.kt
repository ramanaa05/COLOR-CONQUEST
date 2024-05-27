package com.example.color_conquest

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WinnerPage(){
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    Box(
        modifier = Modifier
            .background(Color.White.copy(alpha = 0.7f))
            .fillMaxSize()
    ){
        //confetti animation box
        val align: Alignment
        if(winner.value == playerOne.value.uppercase()) {
            align = Alignment.BottomEnd
        }
        else{
            align = Alignment.TopStart
        }

        Box(
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .background(Color.Transparent)
                .align(align)
        ){
            val n = 10
            val images = listOf(R.drawable.star, R.drawable.fireworks, R.drawable.bell)
            val l = mutableListOf(0)
            l.removeAt(0)
            for (i in 0..n){
                l.add((0..210).random())
            }
            val m = mutableListOf(0)
            m.removeAt(0)
            for (i in 0..n){
                m.add((0..210).random())
            }
            for (i in 0..n){
                val transition = rememberInfiniteTransition(label = "")
                val size by transition.animateFloat(
                    initialValue = 0f,
                    targetValue = 50f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = ((300..700).random()),
                            delayMillis = ((300..700).random())
                        ),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = ""
                )
                Image(
                    modifier = Modifier
                        .size((size).dp)
                        .offset((l[i]).dp, (m[i]).dp),
                    painter = painterResource(id = images.random()),
                    contentDescription = "confetti"
                )
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .align(Alignment.Center)
                .background(Color(0xff3d4175))
                .height(320.dp)
                .width(300.dp)
        ){
            Card(
                modifier = Modifier
                    .width(270.dp)
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .align(Alignment.TopCenter)
                    .background(Color(0xffffffff))
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp)
                        .align(Alignment.CenterHorizontally),
                    text = winner.value,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp
                )
            }
            Text(
                modifier = Modifier
                    .offset(y = (-70).dp)
                    .align(Alignment.Center),
                text = "_______________",
                fontWeight = FontWeight(1000),
                color = Color(0xff54b2de),
                fontSize = 40.sp
            )
            Image(
                modifier = Modifier
                    .offset(y = (-50).dp)
                    .background(Color(0xff3d4175))
                    .size(100.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.trophy),
                contentDescription = "trophy"
            )
            Text(
                modifier = Modifier
                    .offset(y = 5.dp)
                    .align(Alignment.Center),
                text = "WINS!",
                fontWeight = FontWeight(1000),
                color = Color.White,
                fontSize = 25.sp
            )
            Button(
                modifier = Modifier
                    .offset(y = (-70).dp)
                    .height(64.dp)
                    .width(270.dp)
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff01c1f0)),
                onClick = {
                    reset()
                    pageFlag.intValue = 0
                    if (winner.value != ""){
                        updateScoreBoard(preferencesManager, winner.value)
                    }
                    winner.value = ""
                    playerOneWins.intValue = 0
                    playerTwoWins.intValue = 0
                }
            ) {
                Text(
                    modifier = Modifier,
                    text = "Play again",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }
            Button(
                modifier = Modifier
                    .offset(y = (-10).dp)
                    .height(64.dp)
                    .width(270.dp)
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffff5f57)),
                onClick = {
                    reset()
                    playerOne.value = ""
                    playerTwo.value = ""
                    pageFlag.intValue = 0
                    toHome.intValue = 1
                    if (winner.value != ""){
                        updateScoreBoard(preferencesManager, winner.value)
                    }
                    winner.value = ""
                    playerOneWins.intValue = 0
                    playerTwoWins.intValue = 0
                }
            ) {
                Text(
                    modifier = Modifier,
                    text = "Home",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }
        }
    }
}