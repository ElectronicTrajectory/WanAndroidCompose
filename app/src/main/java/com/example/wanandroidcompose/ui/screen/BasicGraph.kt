package com.example.wanandroidcompose.ui.screen

import android.net.Uri
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
        SystemScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }
    composable(Screen.PlaygroundScreen.route) {
        PlaygroundScreen {
            navController.navigate(it)
        }
    }




    composable(Screen.RankScreen.route) {
        RankScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }
    composable(Screen.ShareScreen.route) {
        ShareScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }
    composable(Screen.FavoriteScreen.route) {
        FavoriteScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }
    composable(Screen.HistoryScreen.route) {
        HistoryScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
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
    composable(Screen.UserInfoScreen.route) {
        UserInfoScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }

    composable(Screen.WebViewScreen.route) { backStackEntry ->
        val url = backStackEntry.arguments?.getString("url")
        url?.let {
            val decodedUrl = Uri.decode(url)
            WebViewScreen(decodedUrl, onBack = {
                navController.popBackStack()
            })
        }
    }

}