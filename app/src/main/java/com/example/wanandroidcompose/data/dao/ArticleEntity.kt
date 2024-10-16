package com.example.wanandroidcompose.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "articles", indices = [Index(value = ["title"], unique = true)])
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "link") val link: String,
)