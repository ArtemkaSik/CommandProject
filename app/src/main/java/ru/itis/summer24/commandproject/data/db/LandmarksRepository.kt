
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import ru.itis.summer24.commandproject.data.db.LandmarksDAO
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity
import ru.itis.summer24.commandproject.models.Landmark
import android.content.Context

interface LandmarksRepository {

    fun getLandmarks(): List<Landmark>
    fun getDetails(landmarkID: Long): Landmark
    fun getHistory(): List<Landmark>


    class Impl(
        val landmarksDAO: LandmarksDAO,
    ) : LandmarksRepository{
        override fun getLandmarks(): List<Landmark> {
            return landmarksDAO.getLandmarks()
        }

        override fun getDetails(landmarkId: Long): Landmark {
            return landmarksDAO.getDetails(landmarkId)
        }


        override fun getHistory(): List<Landmark> {
            return landmarksDAO.getHistory()
        }
    }

}