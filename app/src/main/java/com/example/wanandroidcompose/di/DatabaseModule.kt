package com.example.wanandroidcompose.di

import android.content.Context
import androidx.room.Room
import com.example.wanandroidcompose.data.dao.ArticleDao
import com.example.wanandroidcompose.data.dao.ArticleDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ArticleDataBase {
        return Room.databaseBuilder(context, ArticleDataBase::class.java, "article_database")
            .build()
    }

    @Provides
    fun provideArticleDao(database: ArticleDataBase): ArticleDao {
        return database.historyArticleDao()
    }
}