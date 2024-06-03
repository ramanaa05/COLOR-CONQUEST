package com.example.color_conquest

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.LinearEasing
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
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
        ){
            MainPage(navController = navController)
        }
        composable(
            route = Screen.PlayerInformation.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
        ){
            PlayerInformation(navController = navController)
        }
        composable(
            route = Screen.TheGamePage.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
        ){
            TheGamePage(navController = navController)
        }
        composable(
            route = Screen.HackerSelection.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = LinearEasing
                    ),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
        ){
            HackerSelection(navController = navController)
        }
    }
}