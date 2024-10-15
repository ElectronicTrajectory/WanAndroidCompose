package com.example.wanandroidcompose.ui.sealed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Face
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wanandroidcompose.R

sealed class MineMenu(
    val leadingIcon: ImageVector,
    val title: Int,
    val trailingIcon: ImageVector? = Icons.Rounded.ArrowForwardIos,
    val route: String
) {
    object Rank : MineMenu(Icons.Rounded.Face, R.string.mine_menu_rank, route = Screen.RankScreen.route)
    object Share : MineMenu(Icons.Rounded.Face, R.string.mine_menu_share, route = Screen.ShareScreen.route)
    object Collected : MineMenu(Icons.Rounded.Face, R.string.mine_menu_collected, route = Screen.CollectedScreen.route)
    object History : MineMenu(Icons.Rounded.Face, R.string.mine_menu_history, route = Screen.HistoryScreen.route)
    object About : MineMenu(Icons.Rounded.Face, R.string.mine_menu_about, route = Screen.AboutScreen.route)
    object Setting : MineMenu(Icons.Rounded.Face, R.string.mine_menu_setting, route = Screen.SettingScreen.route)
}