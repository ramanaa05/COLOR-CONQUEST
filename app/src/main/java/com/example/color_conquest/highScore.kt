package com.example.color_conquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HighScore(){
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val family = FontFamily(Font(R.font.opensansbold))
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black.copy(alpha = 0.5f))
        .clickable { pageFlag.intValue = 0 }
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ){
            Image(
                modifier = Modifier
                    .size(500.dp),
                painter = painterResource(id = R.drawable.highscore),
                contentDescription = "high Score"
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .offset(y = 36.dp)
                    .width(240.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .align(Alignment.Center)
                    .height(29.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffFAF0D5))
            ) {
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .offset(y = 67.dp)
                    .width(240.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .align(Alignment.Center)
                    .height(29.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffFAF0D5))
            ) {
            }
            Text(
                modifier = Modifier
                    .offset(y = 36.dp)
                    .align(Alignment.Center),
                text = "${preferencesManager.getString("highScorePlayer", defaultValue = "")}",
                fontFamily = family,
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier
                    .offset(y = 67.dp)
                    .align(Alignment.Center),
                text = if(preferencesManager.getInteger("highScore", defaultValue = 0) != 0) "--${preferencesManager.getInteger("highScore", defaultValue = 0)}--" else "",
                fontFamily = family,
                fontSize = 24.sp
            )
        }
    }
}