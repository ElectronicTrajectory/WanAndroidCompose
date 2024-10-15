package com.example.wanandroidcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object{
        lateinit var application: Application
    }
    init {
        application = this
    }
}