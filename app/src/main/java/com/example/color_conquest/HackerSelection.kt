package com.example.color_conquest

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HackerSelection(navController: NavController){
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Black
            )
    ){
        val family = FontFamily(
            Font(R.font.lain)
        )

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.matrix),
            contentDescription = "matrix"
        )

        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 20.dp),
            text = "Hacker Mode",
            fontSize = 50.sp,
            color = Color.White,
            fontFamily = family
        )

        //grid size selector
        Row(
            modifier = Modifier
                .offset(y = 120.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 24.dp),
                text = "grid-size:",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = family
            )
            Box {
                var open by remember { mutableStateOf(false) }
                var size by remember { mutableStateOf("Select") }
                Button(
                    onClick = { open = true },
                    modifier = Modifier
                        .padding(start = 36.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(
                        text = size,
                        fontSize = 24.sp,
                        fontFamily = family
                    )
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "dropdown")
                }
                DropdownMenu(
                    modifier = Modifier
                        .padding(start = 60.dp),
                    expanded = open,
                    onDismissRequest = { open=false}
                ) {
                    DropdownMenuItem(
                        text = { Text("3x3") },
                        onClick = {
                            open = !(open)
                            N.intValue = 3
                            size = "${N.intValue}x${N.intValue}"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("4x4") },
                        onClick = {
                            open = !(open)
                            N.intValue = 4
                            size = "${N.intValue}x${N.intValue}"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("5x5") },
                        onClick = {
                            open = !(open)
                            N.intValue = 5
                            size = "${N.intValue}x${N.intValue}"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("6x6") },
                        onClick = {
                            open = !(open)
                            N.intValue = 6
                            size = "${N.intValue}x${N.intValue}"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("7x7") },
                        onClick = {
                            open = !(open)
                            N.intValue = 7
                            size = "${N.intValue}x${N.intValue}"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("8x8") },
                        onClick = {
                            open = !(open)
                            N.intValue = 8
                            size = "${N.intValue}x${N.intValue}"
                        }
                    )
                }
            }
        }

        //timed mode selector
        val hmode = remember { mutableIntStateOf(0) }
        Box(
            modifier = Modifier
                .padding(top = 200.dp, start = 20.dp)
                .background(Color.Transparent)
        ){
            Box(
                modifier = Modifier
                    .offset(x = 14.dp)
                    .background(Color(0xff35b43f))
                    .align(Alignment.CenterStart)
                    .height(150.dp)
                    .width(20.dp)
            )
            Column {
                Box(
                    modifier = Modifier.background(Color.Transparent)
                ){
                    val color by animateColorAsState(
                        targetValue = if(!(timedMode.value)) Color(0xff006800) else Color(0xff35b43f),
                        label = "green and black"
                    )
                    Button(
                        onClick = { hmode.intValue = 0; timedMode.value = false },
                        modifier = Modifier
                            .size(50.dp),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = color)
                    ){
                    }
                    Image(
                        modifier = Modifier
                            .offset(10.dp)
                            .size(30.dp)
                            .align(Alignment.CenterStart),
                        painter = painterResource(id = R.drawable.infinite),
                        contentDescription = "infinite"
                    )
                    Text(
                        modifier = Modifier
                            .offset(x = 60.dp)
                            .align(Alignment.CenterEnd),
                        text = "Indefinite",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = family
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))

                Box(modifier = Modifier.background(Color.Transparent)){
                    val color by animateColorAsState(
                        targetValue = if(timedMode.value) Color(0xff006800) else Color(0xff35b43f),
                        label = "green and black"
                    )
                    Button(
                        onClick = { hmode.intValue = 1; timedMode.value = true },
                        modifier = Modifier
                            .size(50.dp),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = color)
                    ){}
                    Image(
                        modifier = Modifier
                            .offset(10.dp)
                            .size(30.dp)
                            .align(Alignment.CenterStart),
                        painter = painterResource(id = R.drawable.sandclock),
                        contentDescription = "sand clock"
                    )
                    Text(
                        modifier = Modifier
                            .offset(x = 60.dp)
                            .align(Alignment.CenterEnd),
                        text = "Clocked",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = family
                    )
                }
            }
        }

        //timed mode duration selector
        AnimatedVisibility(
            visible = timedMode.value,
            modifier = Modifier
                .offset(x = 24.dp, y = (-240).dp)
                .background(Color.Transparent)
                .align(Alignment.BottomStart),
            enter = slideInHorizontally (
                animationSpec = tween(
                    durationMillis = 700
                )
            ),
            exit = slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 700
                )
            )
        ){
            Box(
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Minutes:",
                        fontFamily = family,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                    TextField(
                        modifier = Modifier
                            .width(120.dp),
                        textStyle = LocalTextStyle.current.copy(color = Color.White),
                        value = if (timeMinutes.intValue != 0) timeMinutes.intValue.toString() else "",
                        onValueChange = {
                            if(it != ""){
                                timeMinutes.intValue = it.toInt()
                            } else {
                                timeMinutes.intValue = 0
                            }
                        },
                        label = {
                            Text(
                                text = "Enter",
                                color =  Color.White,
                                fontFamily = family
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.DarkGray
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Row (
                    modifier = Modifier
                        .offset(y = 80.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Seconds:",
                        fontFamily = family,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                    TextField(
                        modifier = Modifier
                            .width(120.dp),
                        textStyle = LocalTextStyle.current.copy(color = Color.White),
                        value = if (timeSeconds.intValue != 0) timeSeconds.intValue.toString() else "",
                        onValueChange = {
                            if(it != ""){
                                timeSeconds.intValue = it.toInt()
                            } else {
                                timeSeconds.intValue = 0
                            }
                        },
                        label = {
                            Text(
                                text = "Enter",
                                color =  Color.White,
                                fontFamily = family
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.DarkGray
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            }
        }

        //best of selector
        Text(
            modifier = Modifier
                .offset(x = 24.dp, y = 30.dp)
                .align(Alignment.CenterStart),
            text = "best of: ",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = family
        )
        TextField(
            modifier = Modifier
                .offset(x = 20.dp, y = 30.dp)
                .align(Alignment.Center)
                .width(120.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            value = if (bestOf.intValue != 0) bestOf.intValue.toString() else "",
            onValueChange = {
                if(it != ""){
                    bestOf.intValue = it.toInt()
                } else {
                    bestOf.intValue = 0
                }
            },
            label = {
                Text(
                    text = "Enter",
                    color =  Color.White,
                    fontFamily = family
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.DarkGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        //play button
        Button(
            onClick = {
                if ((bestOf.intValue%2 == 1) or (bestOf.intValue == 0)){
                    navController.navigate(Screen.PlayerInformation.route)
                }
                else{
                    val error = MediaPlayer.create(context, R.raw.error)
                    if (mode.intValue == 2) error.start()
                    Toast.makeText(context, "best-of must be an odd number", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .offset(y = (-24).dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(
                text = "Play",
                fontFamily = family,
                fontSize = 36.sp,
            )
        }

    }
}