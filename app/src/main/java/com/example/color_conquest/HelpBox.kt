package com.example.color_conquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HelpBox(){
    AlertDialog(
        containerColor = Color(0xff6667AA),
        onDismissRequest = { pageFlag.intValue = 0 },
        confirmButton = {
            TextButton(onClick = { pageFlag.intValue = 0 }) {
                Text(
                    text = "Ok",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        },
        title = {
            Text(
                text = "Help",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
        },
        text = {
            Text(
                modifier = Modifier
                    .background(Color(0xff6667AA)),
                color = Color.White,
                text = "-> First move: Click a random tile to capture it and assign a value of 3." +
                        "\n-> After the first move, you are allowed only to click and on those tiles that you have captured. Clicking on it will increase the value on it by one." +
                        "\n-> If a tile's value exceeds 3, it expands resulting in the capture of its neighbors, adding a value of one to them." +
                        "\n-> Such an expansion can take over your opponent's tile if the said tile is a neighbour.",
                fontSize = 18.sp
            )
        }
    )
}