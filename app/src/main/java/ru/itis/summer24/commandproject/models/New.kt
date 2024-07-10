package ru.itis.summer24.commandproject.models

data class New(
    val id: Long,
    val name: String,
    val runame: String,
    val description: String,
    val rudescription: String,
    val date: String,
    val url: String,
)