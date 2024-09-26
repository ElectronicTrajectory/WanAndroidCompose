package com.example.wanandroidcompose.ui.sealed

import com.example.wanandroidcompose.R

sealed class Screen(
    val title: Int,
    val route: String,
) {
    object HomeScreen : Screen(R.string.home_screen, "home_screen")
    object QAScreen : Screen(R.string.qa_screen, "qa_screen",)
    object SystemScreen : Screen(R.string.system_screen, "system_screen")
    object MineScreen : Screen(R.string.mine_screen, "mine_screen")
    object FavoriteScreen : Screen(R.string.favorite_screen, "favorite_screen")
    object PlaygroundScreen : Screen(R.string.playground_screen, "playground_screen")

}
