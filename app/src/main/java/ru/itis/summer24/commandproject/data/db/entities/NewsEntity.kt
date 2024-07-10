package ru.itis.summer24.commandproject.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    @ColumnInfo(defaultValue = "defaultValue")
    val runame: String,
    val description: String,
    @ColumnInfo(defaultValue = "defaultValue")
    val rudescription: String,
    val date: String,
    val url: String,
)