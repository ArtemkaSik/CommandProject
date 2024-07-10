package ru.itis.summer24.commandproject.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "landmarks")
data class LandmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    @ColumnInfo(defaultValue = "defaultValue")
    val runame: String,
    val imageUrl: String,
    val city: String,
    @ColumnInfo(defaultValue = "defaultValue")
    val rucity: String,
    val shortInformation: String,
    @ColumnInfo(defaultValue = "defaultValue")
    val rushortInformation: String,
    val longInformation: String,
    @ColumnInfo(defaultValue = "defaultValue")
    val rulongInformation: String,
    val visit: Int
)