import ru.itis.summer24.commandproject.models.Landmark
import android.content.Context
import androidx.room.Room
import ru.itis.summer24.commandproject.data.db.LandmarksDatabase
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity

class LandmarksRepository(context: Context) {
    private val db by lazy {
            Room.databaseBuilder(context, LandmarksDatabase::class.java, "LandMarksDB")
                .allowMainThreadQueries()
                .build()
    }
    private val landmarksDAO by lazy {
        db.getDao()
    }

    suspend fun getLandmarks(): List<Landmark> {
        return landmarksDAO.getLandmarks()
        }

    suspend fun searchItems(string: String): List<Landmark> {
        return landmarksDAO.searchItems(string)
    }

    suspend fun getDetails(landmarkId: Long): Landmark {
        return landmarksDAO.getDetails(landmarkId)
    }

    suspend fun getHistory(): List<Landmark> {
        return landmarksDAO.getHistory()
    }
    suspend fun updateVisit(id: Long) {
        landmarksDAO.updateVisit(id)
    }

    suspend fun addLandmark(landmark: LandmarkEntity) {
        landmarksDAO.add(landmark)
    }
}

