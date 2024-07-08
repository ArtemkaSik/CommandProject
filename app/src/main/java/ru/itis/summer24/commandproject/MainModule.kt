package ru.itis.summer24.commandproject

import LandmarksRepository
import ru.itis.summer24.commandproject.data.db.LandmarksDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainModule(val app: App) {

    val database by lazy {
        LandmarksDatabase.create(app)
    }
    val repository: LandmarksRepository by lazy { LandmarksRepository.Impl(landmarksDao) }

    val executorService: ExecutorService by lazy { Executors.newCachedThreadPool() }

    val landmarksDao by lazy {
        database.getDao()
    }
    }
