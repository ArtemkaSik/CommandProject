package ru.itis.summer24.commandproject

import ru.itis.summer24.commandproject.data.LandmarksRepository
import ru.itis.summer24.commandproject.data.db.LandmarksDatabase
import ru.itis.summer24.commandproject.data.db.TypeConverters
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainModule(val app: App) {

    val database by lazy {
        LandmarksDatabase.create(app)
    }

    val landmarksDao by lazy {
        database.getDao()
    }

    val executorService: ExecutorService by lazy { Executors.newCachedThreadPool() }

    val repository: LandmarksRepository by lazy {
        LandmarksRepository.Impl(
            landmarksDao
        )
    }
}