package com.example.wanandroidcompose.di

import android.content.Context
import com.example.wanandroidcompose.network.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNavigator(context: Context): Navigator {
        return NavigatorImpl(context)
    }

}

class NavigatorImpl(private val context: Context) : Navigator {
    override fun navigateToLogin() {
//        val intent = Intent(context, LoginActivity::class.java)
//        context.startActivity(intent)
    }
}
