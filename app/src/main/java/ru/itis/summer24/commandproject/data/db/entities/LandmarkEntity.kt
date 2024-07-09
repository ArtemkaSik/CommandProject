package ru.itis.summer24.commandproject.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.itis.summer24.commandproject.models.Landmark

@Entity(tableName = "landmarks")
data class LandmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val imageUrl: String,
    val city: String,
    val shortInformation: String,
    val longInformation: String,
    val visit: Int
) {
    fun toModel(): Landmark = Landmark(
        id, name, imageUrl, city, shortInformation, longInformation, visit
    )
}