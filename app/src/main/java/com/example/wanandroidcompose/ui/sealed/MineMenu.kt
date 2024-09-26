package com.example.wanandroidcompose.ui.sealed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Face2
import androidx.compose.material.icons.rounded.Face3
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wanandroidcompose.R

sealed class MineMenu(
    val leadingIcon: ImageVector,
    val title: Int,
    val trailingIcon: ImageVector? = Icons.Rounded.ArrowForwardIos,
    val route: String
) {
    object Rank : MineMenu(Icons.Rounded.Face, R.string.mine_menu_rank, route = "rank_screen")
    object Share : MineMenu(Icons.Rounded.Face, R.string.mine_menu_share, route = "share_screen")
    object Favorite : MineMenu(Icons.Rounded.Face, R.string.mine_menu_favorite, route = "favorite_screen")
    object Bookmark : MineMenu(Icons.Rounded.Face, R.string.mine_menu_bookmark, route = "bookmark_screen")
    object History : MineMenu(Icons.Rounded.Face, R.string.mine_menu_history, route = "history_screen")
    object About : MineMenu(Icons.Rounded.Face, R.string.mine_menu_about, route = "about_screen")
    object Setting : MineMenu(Icons.Rounded.Face, R.string.mine_menu_setting, route = "setting_screen")
}