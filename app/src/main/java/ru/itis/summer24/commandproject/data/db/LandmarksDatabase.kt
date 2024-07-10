package ru.itis.summer24.commandproject.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity



@Database(
    entities = [LandmarkEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ],
    exportSchema = true
)
abstract class LandmarksDatabase :  RoomDatabase(){

    abstract fun getDao(): LandmarksDAO

}