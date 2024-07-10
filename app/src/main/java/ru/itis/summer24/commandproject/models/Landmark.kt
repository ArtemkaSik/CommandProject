package ru.itis.summer24.commandproject.models

data class Landmark(
    val id: Long,
    val name: String,
    val runame: String,
    val imageUrl: String,
    val city: String,
    val rucity: String,
    val shortInformation: String,
    val rushortInformation: String,
    val longInformation: String,
    val rulongInformation: String,
    val visit: Int
)
