package com.example.wanandroidcompose.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ArticleEntity::class], version = 1)
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun articleDap(): ArticleDao
}