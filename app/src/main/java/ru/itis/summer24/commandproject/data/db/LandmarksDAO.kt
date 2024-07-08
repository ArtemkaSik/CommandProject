package ru.itis.summer24.commandproject.data.db

import androidx.room.Dao
import androidx.room.Query


import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity
import ru.itis.summer24.commandproject.models.Landmark


@Dao
interface LandmarksDAO {
    @Query("""
        SELECT * FROM landmarks WHERE visit=0
    """)
    fun getLandmarks(): List<Landmark>

    @Query("""
        SELECT * FROM landmarks WHERE id = :landmarkId
        """)
    fun getDetails(landmarkId: Long): Landmark

    @Query("""
        SELECT * FROM landmarks WHERE visit=1
        """)
    fun getHistory(): List<Landmark>

}