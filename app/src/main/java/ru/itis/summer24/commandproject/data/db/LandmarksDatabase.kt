package ru.itis.summer24.commandproject.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity



@Database(
    entities = [LandmarkEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ru.itis.summer24.commandproject.data.db.TypeConverters::class)
abstract class LandmarksDatabase :  RoomDatabase(){

    abstract fun getDao(): LandmarksDAO

}