package com.example.color_conquest

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreBoard(){
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = preferencesManager.getAllKeys()
    AlertDialog(
        onDismissRequest = { pageFlag.intValue = 0 },
        confirmButton = {
            TextButton(onClick = { pageFlag.intValue = 0 }) {
                Text(text = "Ok")
            }
        },
        title = {
            Text(
                text = "SCORE BOARD",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
        },
        text = {
            LazyColumn {
                items(count = data.size){
                    var name: String = data.elementAt(it)
                    Row{
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp, end = 20.dp),
                            text = name,
                            fontSize = 20.sp,
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp, end = 5.dp),
                            text = preferencesManager.getData(name, 0).toString(),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    )
}