package ru.itis.summer24.commandproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.summer24.commandproject.data.db.entities.NewsEntity



@Database(
    entities = [NewsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase :  RoomDatabase(){

    abstract fun getDao(): NewsDAO

}