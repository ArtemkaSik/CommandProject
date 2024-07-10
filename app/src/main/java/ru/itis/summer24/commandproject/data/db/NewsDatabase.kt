package ru.itis.summer24.commandproject.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.itis.summer24.commandproject.data.db.entities.NewsEntity



@Database(
    entities = [NewsEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration (from = 1, to = 2, spec = NewsDatabase.MyAutoMigration::class)
    ],
    exportSchema = true
)
abstract class NewsDatabase :  RoomDatabase(){

    abstract fun getDao(): NewsDAO

    @RenameColumn(tableName = "news", fromColumnName = "city", toColumnName = "date")
    class MyAutoMigration : AutoMigrationSpec
}