package com.example.wanandroidcompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles ORDER BY last_read_time DESC LIMIT :limit OFFSET :offset")
    suspend fun getArticlesByPage(limit: Int, offset: Int): List<ArticleEntity>

    @Query("UPDATE articles SET last_read_time = :timestamp WHERE link = :link")
    suspend fun updateReadTime(link: String, timestamp: Long)

    @Query("SELECT * FROM articles WHERE link = :link LIMIT 1")
    suspend fun getArticleByLink(link: String): ArticleEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(articleEntity: ArticleEntity)

    @Delete
    suspend fun delete(articleEntity: ArticleEntity)
}

