package com.example.wanandroidcompose.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        go2Next()
    }

    private fun go2Next() {
        val aimCls: Class<*> = MainActivity::class.java
        startActivity(Intent(this, aimCls))
        finish()
    }
}