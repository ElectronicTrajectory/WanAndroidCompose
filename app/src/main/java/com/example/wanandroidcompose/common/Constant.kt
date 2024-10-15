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
        MineMenu.Collected,
        MineMenu.History,
        MineMenu.About,
        MineMenu.Setting
    )


val blankOrNull = "---"


val MikuImageLink = "https://ts2.cn.mm.bing.net/th?id=OIP.2sI-q7UlIi6zLgWLjLYS6AHaHa"