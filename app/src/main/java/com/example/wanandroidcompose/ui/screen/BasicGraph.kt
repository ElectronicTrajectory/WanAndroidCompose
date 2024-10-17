package com.example.wanandroidcompose.ui.screen

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.blankj.utilcode.util.GsonUtils
import com.example.wanandroidcompose.common.json2ArticleForWebScreen
import com.example.wanandroidcompose.data.model.Article
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
    composable(Screen.CollectedScreen.route) {
        CollectedScreen(navigate = {
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
        SettingScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }
    composable(Screen.UserInfoScreen.route) {
        UserInfoScreen(navigate = {
            navController.navigate(it)
        }, onBack = {
            navController.popBackStack()
        })
    }

    composable(Screen.WebViewScreen.route) { backStackEntry ->
        val article = json2ArticleForWebScreen(backStackEntry.arguments)

        article?.let {
            WebViewScreen(it, onBack = {
                navController.popBackStack()
            })
        }
    }
}