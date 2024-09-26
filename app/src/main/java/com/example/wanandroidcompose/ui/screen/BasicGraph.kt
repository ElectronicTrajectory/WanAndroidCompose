package com.example.wanandroidcompose.ui.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.wanandroidcompose.ui.sealed.Screen


fun NavGraphBuilder.addGraph(navController: NavHostController) {

    composable(Screen.LoginScreen.route) {
        LoginScreen {
            navController.popBackStack()
        }
    }


    composable(Screen.HomeScreen.route) {
        HomeScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.QAScreen.route) {
        QAScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.MineScreen.route) {
        MineScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.SystemScreen.route) {
        SystemScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.FavoriteScreen.route) {
        FavoriteScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.PlaygroundScreen.route) {
        PlaygroundScreen {
            navController.navigate(it)
        }
    }




    composable(Screen.RankScreen.route) {
        RankScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.ShareScreen.route) {
        ShareScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.FavoriteScreen.route) {
        FavoriteScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.BookmarkScreen.route) {
        BookmarkScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.HistoryScreen.route) {
        HistoryScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.AboutScreen.route) {
        AboutScreen {
            navController.navigate(it)
        }
    }
    composable(Screen.SettingScreen.route) {
        SettingScreen {
            navController.navigate(it)
        }
    }

}