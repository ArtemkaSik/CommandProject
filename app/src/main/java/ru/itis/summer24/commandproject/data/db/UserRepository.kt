import ru.itis.summer24.commandproject.models.User
import android.content.Context
import androidx.room.Room
import ru.itis.summer24.commandproject.data.db.UserDataBase
import ru.itis.summer24.commandproject.data.db.entities.UserEntity

class UserRepository(context: Context) {
    private val udb by lazy {
        Room.databaseBuilder(context, UserDataBase::class.java, "UserDB")
            .allowMainThreadQueries()
            .build()
    }
    private val userDAO by lazy {
        udb.userDao()
    }

    suspend fun registerUser(username: String, password: String) {
        userDAO.insert(UserEntity(username = username, password = password))
    }

    suspend fun loginUser(username: String, password: String): Boolean {
        val user = userDAO.getUserByUsername(username)
        return user?.password == password
    }
}