import ru.itis.summer24.commandproject.models.Landmark
import android.content.Context
import androidx.room.Room
import ru.itis.summer24.commandproject.data.db.LandmarksDatabase

class LandmarksRepository(context: Context) {
    private val db by lazy {
            Room.databaseBuilder(context, LandmarksDatabase::class.java, "DB")
                .allowMainThreadQueries()
                .createFromAsset("lmDB.db")
                .build()
    }
    private val landmarksDAO by lazy {
        db.getDao()
    }

    suspend fun getLandmarks(): List<Landmark> {
        return landmarksDAO.getLandmarks()
        }


    suspend fun getDetails(landmarkId: Long): Landmark {
        return landmarksDAO.getDetails(landmarkId)
    }

    suspend fun getHistory(): List<Landmark> {
        return landmarksDAO.getHistory()
    }
}

