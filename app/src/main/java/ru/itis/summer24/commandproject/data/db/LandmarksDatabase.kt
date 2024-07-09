package ru.itis.summer24.commandproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity



@Database(
    entities = [LandmarkEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LandmarksDatabase :  RoomDatabase(){

    abstract fun getDao(): LandmarksDAO

}