package ru.itis.summer24.commandproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import ru.itis.summer24.commandproject.data.db.LandmarksDAO
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity
import ru.itis.summer24.commandproject.models.Landmark

interface LandmarksRepository {

    fun getLandmarks(): LiveData<List<Landmark>>
    fun getHistory(): LiveData<List<Landmark>>
    fun getDetails(landmarkId: Long): LiveData<Landmark>

    class Impl(
        val landmarkDAO: LandmarksDAO,
    ) : LandmarksRepository {
        override fun getLandmarks(): LiveData<List<Landmark>> {
            return landmarkDAO.getLandmarks().map { landmarkEntities ->
                landmarkEntities.map(LandmarkEntity::toModel)
            }
        }

        override fun getDetails(landmarkId: Long): LiveData<Landmark> {
            return landmarkDAO.getDetails(landmarkId)
            }


        override fun getHistory(): LiveData<List<Landmark>> {
            return landmarkDAO.getHistory().map { landmarkEntities ->
                landmarkEntities.map(LandmarkEntity::toModel)
            }
        }
    }
}