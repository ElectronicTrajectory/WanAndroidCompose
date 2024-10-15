package com.example.wanandroidcompose.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "type") val type: String,
)