package ru.itis.summer24.commandproject.models

data class Landmark(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val city: String,
    val shortInformation: String,
    val longInformation: String,
    val visit: Int
)
