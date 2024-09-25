package com.example.wanandroidcompose.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.wanandroidcompose.ui.screen.addGraph
import com.example.wanandroidcompose.ui.sealed.Screen

@Composable
fun AppNaviHost(navController: NavHostController) {
    NavHost(
        navController,
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        startDestination = Screen.HomeScreen.route,
        enterTransition = {
            fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(300))
        }
    ) {
        addGraph(navController)
    }
}