package ru.itis.summer24.commandproject.models

data class New(
    val id: Long,
    val name: String,
    val description: String,
    val city: String,
    val url: String,
)