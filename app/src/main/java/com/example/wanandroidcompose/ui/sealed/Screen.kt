package com.example.wanandroidcompose.ui.sealed

import com.example.wanandroidcompose.R

sealed class Screen(
    val title: Int,
    val route: String,
) {
    object LoginScreen : Screen(R.string.login, "login_screen")
    object HomeScreen : Screen(R.string.home_screen, "home_screen")
    object QAScreen : Screen(R.string.qa_screen, "qa_screen",)
    object SystemScreen : Screen(R.string.system_screen, "system_screen")
    object MineScreen : Screen(R.string.mine_screen, "mine_screen")
    object PlaygroundScreen : Screen(R.string.playground_screen, "playground_screen")

    object UserInfoScreen : Screen(R.string.mine_user_info, "userinfo_screen")
    object RankScreen : Screen(R.string.mine_menu_rank, "rank_screen")
    object ShareScreen : Screen(R.string.mine_menu_share, "share_screen")
    object FavoriteScreen : Screen(R.string.mine_menu_favorite, "favorite_screen")
    object HistoryScreen : Screen(R.string.mine_menu_history, "history_screen")
    object AboutScreen : Screen(R.string.mine_menu_about, "about_screen")
    object SettingScreen : Screen(R.string.mine_menu_setting, "setting_screen")

    object WebViewScreen : Screen(R.string.web, "web/{url}")

}
