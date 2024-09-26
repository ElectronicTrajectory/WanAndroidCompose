package com.example.wanandroidcompose.common

import com.example.wanandroidcompose.ui.sealed.MineMenu
import com.example.wanandroidcompose.ui.sealed.Screen

val topLevelScreens = listOf(
    Screen.HomeScreen, Screen.PlaygroundScreen, Screen.QAScreen, Screen.MineScreen
)

val mineMenuItems =
    listOf(
        MineMenu.Rank,
        MineMenu.Share,
        MineMenu.Favorite,
        MineMenu.Bookmark,
        MineMenu.History,
        MineMenu.About,
        MineMenu.Setting
    )


val blankOrNull = "---"
