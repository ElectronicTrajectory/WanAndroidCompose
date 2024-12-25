package com.example.wanandroidcompose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropDin
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.wanandroidcompose.common.topLevelScreens
import com.example.wanandroidcompose.ui.sealed.Screen

@Composable
fun AppNavigationBar(modifier: Modifier, navController: NavHostController, currentRoute: String?) {

    NavigationBar(modifier) {
        topLevelScreens.forEach { screen ->
            val icon = getTopLevelScreenIcon(screen)
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = screen.title), style = MaterialTheme.typography.bodySmall)
                },
                alwaysShowLabel = true
            )
        }
    }
}

private fun getTopLevelScreenIcon(screen: Screen): ImageVector {
    return when (screen) {
        Screen.HomeScreen -> {
            Icons.Default.ReceiptLong
        }
        Screen.QAScreen -> {
            Icons.Default.QuestionAnswer
        }
        Screen.SystemScreen -> {
            Icons.Default.LibraryBooks
        }
        Screen.MineScreen -> {
            Icons.Default.Face
        }

        else -> {
            Icons.Default.CropDin
        }
    }
}