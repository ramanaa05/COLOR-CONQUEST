package com.example.color_conquest

sealed class Screen(val route: String) {
    data object MainPage : Screen("main_page")
    data object PlayerInformation : Screen("player_information")
    data object TheGamePage : Screen("the_game_page")
    data object HackerSelection: Screen("hacker_selection")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}