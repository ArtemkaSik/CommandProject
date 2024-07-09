package ru.itis.summer24.commandproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import ru.itis.summer24.commandproject.data.db.entities.UserEntity
import ru.itis.summer24.commandproject.models.Landmark
import ru.itis.summer24.commandproject.models.User

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): UserEntity?
}