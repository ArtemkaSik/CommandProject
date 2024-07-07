package ru.itis.summer24.commandproject.models

import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity

data class Landmark(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val city: String,
    val shortInformation: String,
    val longInformation: String,
    val visit: Int
) {

    fun toEntity() = LandmarkEntity(
        id, name, imageUrl, city, shortInformation, longInformation, visit
    )
}