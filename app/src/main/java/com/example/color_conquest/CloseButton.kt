package com.example.color_conquest

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CloseButton() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent.copy(alpha = 0.6f))
            .clickable { pageFlag.intValue = 0; pause.value = false }
    ) {
        Box(
            modifier = Modifier
                .offset(y = (-100).dp)
                .clip(RoundedCornerShape(100))
                .size(350.dp)
                .align(Alignment.Center)
                .background(Color.Black.copy(alpha = 0.5f))
        ) {
            Box(
                modifier = Modifier
                    .offset(y = 10.dp)
                    .align(Alignment.TopCenter)
            )
            {
                Button(
                    onClick = {
                        reset()
                        pageFlag.intValue = 0
                        pause.value = false
                        setTime.value = true
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(25))
                        .size(100.dp)
                        .align(Alignment.Center),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff9103B5))
                ) {
                }
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.undo),
                    contentDescription = "re-game"
                )
            }
            Box(
                modifier = Modifier
                    .offset(x = 10.dp)
                    .align(Alignment.CenterStart)
            ) {
                Button(
                    onClick = { pageFlag.intValue = 0; pause.value = false },
                    modifier = Modifier
                        .clip(RoundedCornerShape(25))
                        .size(100.dp)
                        .align(Alignment.Center),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff20ab45))
                ) {

                }
                Image(
                    modifier = Modifier
                        .offset(x = 2.dp)
                        .size(50.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.play_button),
                    contentDescription = "play"
                )
            }
            Box(
                modifier = Modifier
                    .offset(x = (-10).dp)
                    .align(Alignment.CenterEnd)
            ) {
                Button(
                    onClick = {
                        val swoosh = MediaPlayer.create(context, R.raw.swoosh)
                        if (mode.intValue == 2) swoosh.start()
                        reset()
                        playerOne.value = ""
                        playerTwo.value = ""
                        pageFlag.intValue = 0
                        toHome.intValue = 1
                        playerOneWins.intValue = 0
                        playerTwoWins.intValue = 0
                        pause.value = false
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(25))
                        .size(100.dp)
                        .align(Alignment.Center)
                ) {

                }
                Image(
                    modifier = Modifier
                        .size(105.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.exit_game),
                    contentDescription = "exit game"
                )
            }
            Box(
                modifier = Modifier
                    .offset(y = (-10).dp)
                    .align((Alignment.BottomCenter))
            ) {
                Button(
                    onClick = {
                        android.os.Process.killProcess(android.os.Process.myPid())
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(25))
                        .size(100.dp)
                        .align(Alignment.Center),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                }
                Image(
                    modifier = Modifier
                        .offset(x = (-5).dp)
                        .size(50.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.exit_app),
                    contentDescription = "exit app"
                )
            }
        }

    }
}