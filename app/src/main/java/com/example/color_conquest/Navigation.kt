package com.example.color_conquest

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.color_conquest.MainPage
import com.example.color_conquest.PlayerInformation
import com.example.color_conquest.Screen
import com.example.color_conquest.TheGamePage

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainPage.route){
        composable(
            route = Screen.MainPage.route,
        ){
            MainPage(navController = navController)
        }
        composable(
            route = Screen.PlayerInformation.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = spring(0.3f),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 1000
                    )
                )
            }
        ){
            PlayerInformation(navController = navController)
        }
        composable(
            route = Screen.TheGamePage.route,
            enterTransition = {
                expandIn(
                    animationSpec = tween(300),
                    expandFrom = Alignment.Center
                )
            },
            exitTransition = {
                shrinkOut (
                    animationSpec = tween(300),
                    shrinkTowards = Alignment.Center
                )
            }
        ){
            TheGamePage(navController = navController)
        }
        composable(
            route = Screen.HackerSelection.route,
        ){
            HackerSelection(navController = navController)
        }
    }
}