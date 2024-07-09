package ru.itis.summer24.commandproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.summer24.commandproject.data.db.entities.UserEntity


@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDAO
}