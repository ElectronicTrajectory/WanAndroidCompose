package com.example.wanandroidcompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wanandroidcompose.common.topLevelScreens
import com.example.wanandroidcompose.ui.AppNaviHost
import com.example.wanandroidcompose.ui.AppNavigationBar
import com.example.wanandroidcompose.ui.theme.WanAndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WanAndroidComposeTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val current = navBackStackEntry?.destination?.route
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (topLevelScreens.any { it.route == current }) {
                            AppNavigationBar(
                                Modifier,
                                navController,
                                current
                            )
                        }
                    }
                ) { innerPadding ->
                    AppNaviHost(navController)
                }
            }
        }
    }
}
