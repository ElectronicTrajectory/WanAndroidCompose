package com.example.wanandroidcompose.ui.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wanandroidcompose.common.toast
import com.example.wanandroidcompose.common.topLevelScreens
import com.example.wanandroidcompose.ui.AppNaviHost
import com.example.wanandroidcompose.ui.AppNavigationBar
import com.example.wanandroidcompose.ui.sealed.Screen
import com.example.wanandroidcompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val context = LocalContext.current
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
                    CompositionLocalProvider(
                        LocalInnerPadding provides innerPadding,
                    ) {
                        AppNaviHost(navController)
                    }
                }

                val receiver = remember {
                    object : BroadcastReceiver() {
                        override fun onReceive(context: Context?, intent: Intent?) {
                            navController.navigate(Screen.LoginScreen.route)
                        }
                    }
                }
                DisposableEffect(key1 = Unit) {
                    val filter = IntentFilter("Logout")
                    context.registerReceiver(receiver,filter)
                    onDispose {
                        context.unregisterReceiver(receiver)
                    }
                }
            }
        }
    }
}

val LocalInnerPadding =
    staticCompositionLocalOf<PaddingValues> { error("No localSystemBarHeight provided") }