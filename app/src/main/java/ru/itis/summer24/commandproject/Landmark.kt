package ru.itis.summer24.commandproject

data class Landmark (
    val id: Int,
    val name: String,
    val city: String,
    val imageUrl: String,
    val shortDescription: String,
    val longDescription: String,
    val visit: Int
)
