package com.example.color_conquest

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HelpBox(){
    AlertDialog(
        onDismissRequest = { pageFlag.intValue = 0 },
        confirmButton = {
            TextButton(onClick = { pageFlag.intValue = 0 }) {
                Text(text = "Ok")
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
                text = "NIGGA, WHAT?",
                fontSize = 18.sp
            )
        }
    )
}