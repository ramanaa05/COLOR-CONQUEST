package com.example.color_conquest

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var powerUpDescription = mutableStateOf("")
var power = mutableStateOf(R.drawable.world)
var inv: Float = 0.0f

@Composable
fun PowerUps(){
    val powers = listOf(R.drawable.world, R.drawable.extratime, R.drawable.plusone)
    var color: Color
    var alignment: Alignment
    var offset: Int

    if (currentLoss.intValue == 1){
        alignment = Alignment.BottomCenter
        inv = 0f
        color = Color(0xffff5f57)
        offset = -60
    }
    else{
        alignment = Alignment.TopCenter
        inv = 180f
        color = Color(0xff2fb6f0)
        offset = 60
    }

    Box(
        modifier = Modifier
            .background(Color.White.copy(alpha = 0.7f))
            .fillMaxSize()
    ){
        val touched = remember{ mutableStateOf(false) }
        val sizeIcon by animateIntAsState(
            targetValue = if(touched.value) 50 else 0,
            label = "",
            animationSpec = tween(
                durationMillis = 300
            )
        )
        Box(
            modifier = Modifier
                .offset(y = offset.dp)
                .align(alignment)
        ){
            Button(
                onClick = {
                    grantedTo.intValue = currentLoss.intValue
                    power.value = powers.random()
                    touched.value = true
                    poweInfo.value = true
                    if(power.value == powers[0]){
                        powerUpDescription.value = "You have received the ability to click on any tile regardless of whether it is your first turn. Note that you cannot click on tiles conquered by the other player and this can only be use once!!"
                        grantedPowerUp.intValue = 1
                    }
                    else if (power.value == powers[1]){
                        powerUpDescription.value = "You have been granted one min of extra time"
                        grantedPowerUp.intValue = 2
                    }
                    else{
                        powerUpDescription.value = "You have been given the ability to play two continuous turns. Note that your clock will still be running!!"
                        grantedPowerUp.intValue = 3
                    }
                },
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.Center),
                shape = RoundedCornerShape(100),
                colors = ButtonDefaults.buttonColors(containerColor = color)
            ) {
            }
            if (touched.value){
                Image(
                    modifier = Modifier
                        .size(sizeIcon.dp)
                        .align(Alignment.Center)
                        .rotate(inv),
                    painter = painterResource(id = power.value),
                    contentDescription = "random power-up"
                )
            }
        }
    }
}

@Composable
fun PowerupInfo(){
    AlertDialog(
        modifier = Modifier
            .rotate(inv),
        onDismissRequest = { pageFlag.intValue = 0; poweInfo.value = false; currentLoss.intValue = 0 },
        confirmButton = {
            TextButton(onClick = { pageFlag.intValue = 0; poweInfo.value = false; currentLoss.intValue = 0 }) {
                Text(text = "Ok")
            }
        },
        title = {
            Text(
                text = "CONGRATS",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
        },
        text = {
            Text(
                text = powerUpDescription.value,
                fontSize = 18.sp
            )
        }
    )
}