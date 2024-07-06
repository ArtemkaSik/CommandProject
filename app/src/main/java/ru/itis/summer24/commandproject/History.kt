package ru.itis.summer24.commandproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val city: String,
    val url: String,
    val description: String
)
