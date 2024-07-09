package ru.itis.summer24.commandproject.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert

import ru.itis.summer24.commandproject.data.db.entities.NewsEntity
import ru.itis.summer24.commandproject.models.New


@Dao
interface NewsDAO {
    @Query("""
        SELECT * FROM news WHERE id = :newsId
        """)
    suspend fun getDetails(newsId: Long): New

    @Insert
    suspend fun add(news: NewsEntity)

}