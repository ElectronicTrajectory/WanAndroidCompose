package com.example.wanandroidcompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articleentity")
    fun getAll(): List<ArticleEntity>

    @Insert
    fun insertAll(vararg articleEntities: ArticleEntity)

    @Delete
    fun delete(articleEntities: ArticleEntity)
}

