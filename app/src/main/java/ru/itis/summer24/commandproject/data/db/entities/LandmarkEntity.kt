package ru.itis.summer24.commandproject.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "landmarks")
data class LandmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val imageUrl: String,
    val city: String,
    val shortInformation: String,
    val longInformation: String,
    val visit: Int
)