package com.example.color_conquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerInformation(navController: NavController){
    remember {
        playerOne
    }
    remember {
        playerTwo
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xffffc271),
                        Color(0xffff5f6d)
                    )
                )
            )
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 36.dp)
                    .shadow(10.dp, CutCornerShape(24.dp))
                    .border(
                        BorderStroke(
                            width = 3.dp,
                            color = Color(0xffcdb6b6)
                        ),
                        shape = CutCornerShape(24.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffffd6b7)
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp, bottom = 4.dp, start = 24.dp, end = 24.dp),
                    text = "PLAYER INFORMATION",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            Button(
                onClick = { navController.navigate(Screen.TheGamePage.route)},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 96.dp)
                    .shadow(5.dp, RoundedCornerShape(36.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2fb6f0)
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 38.dp, end = 38.dp, top = 6.dp, bottom = 6.dp),
                    text = "START",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .size(380.dp)
                    .offset(y = 108.dp),
                painter = painterResource(id = R.drawable.versus),
                contentDescription = "versus",
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            Image(
                modifier = Modifier
                    .size(180.dp)
                    .offset(x = 16.dp, y = 155.dp),
                painter = painterResource(id = R.drawable.player1),
                contentDescription = "Player 1",
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            Image(
                modifier = Modifier
                    .size(180.dp)
                    .offset(x = 16.dp, y = 280.dp),
                painter = painterResource(id = R.drawable.player2),
                contentDescription = "Player 2",
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            Box(
                modifier = Modifier
                    .offset(y = 204.dp, x = (-18).dp)
                    .shadow(5.dp, shape = RoundedCornerShape(27.dp))
                    .background(color = Color(0xff3d4175))
                    .height(100.dp)
                    .width(190.dp)
                    .align(Alignment.TopEnd)
            ){
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 48.dp),
                    textStyle = LocalTextStyle.current.copy(color = Color(0xffff5f57)),
                    value = playerOne.value,
                    label = {
                        Text(
                            text = "Enter Player-1 Name",
                            color =  Color(0xff5c6690)
                        )
                    },
                    onValueChange = {
                        playerOne.value = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xff3d4175)
                    )
                )
                Image(
                    modifier = Modifier
                        .size(54.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 9.dp),
                    painter = painterResource(id = R.drawable.red_player),
                    contentDescription = "red player icon"
                )
                Text(
                    modifier = Modifier
                        .offset(y = 22.dp)
                        .align(Alignment.BottomCenter),
                    text = "-----------",
                    fontSize = 50.sp,
                    color = Color(0xffff5f57)
                )
            }

            Box(
                modifier = Modifier
                    .offset(y = 327.dp, x = (-18).dp)
                    .shadow(5.dp, shape = RoundedCornerShape(27.dp))
                    .background(color = Color(0xff3d4175))
                    .height(100.dp)
                    .width(190.dp)
                    .align(Alignment.TopEnd)
            ){
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 48.dp),
                    textStyle = LocalTextStyle.current.copy(color = Color(0xff2fb6f0)),
                    value = playerTwo.value,
                    label = {
                        Text(
                            text = "Enter Player-2 Name",
                            color =  Color(0xff5c6690)
                        )
                    },
                    onValueChange = {
                        playerTwo.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xff3d4175),
                    )
                )
                Image(
                    modifier = Modifier
                        .size(54.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 9.dp),
                    painter = painterResource(id = R.drawable.blue_player),
                    contentDescription = "blue player icon"
                )
                Text(
                    modifier = Modifier
                        .offset(y = 22.dp)
                        .align(Alignment.BottomCenter),
                    text = "-----------",
                    fontSize = 50.sp,
                    color = Color(0xff30abe4)
                )
            }
        }
    }
}