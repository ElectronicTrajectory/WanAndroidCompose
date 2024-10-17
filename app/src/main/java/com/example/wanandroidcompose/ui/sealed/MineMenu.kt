package com.example.wanandroidcompose.ui.sealed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Paid
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Sell
import androidx.compose.material.icons.rounded.SentimentSatisfied
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material.icons.rounded.TagFaces
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wanandroidcompose.R

sealed class MineMenu(
    val leadingIcon: ImageVector,
    val title: Int,
    val trailingIcon: ImageVector? = Icons.Rounded.ArrowForwardIos,
    val route: String
) {
    object Rank : MineMenu(Icons.Rounded.Sell, R.string.mine_menu_rank, route = Screen.RankScreen.route)
    object Share : MineMenu(Icons.Rounded.Share, R.string.mine_menu_share, route = Screen.ShareScreen.route)
    object Collected : MineMenu(Icons.Rounded.Favorite, R.string.mine_menu_collected, route = Screen.CollectedScreen.route)
    object History : MineMenu(Icons.Rounded.Cloud, R.string.mine_menu_history, route = Screen.HistoryScreen.route)
    object About : MineMenu(Icons.Rounded.Face, R.string.mine_menu_about, route = Screen.AboutScreen.route)
    object Setting : MineMenu(Icons.Rounded.Settings, R.string.mine_menu_setting, route = Screen.SettingScreen.route)
}