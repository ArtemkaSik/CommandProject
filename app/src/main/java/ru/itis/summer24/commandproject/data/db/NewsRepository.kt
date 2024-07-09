import ru.itis.summer24.commandproject.models.New
import android.content.Context
import androidx.room.Room
import ru.itis.summer24.commandproject.data.db.NewsDatabase
import ru.itis.summer24.commandproject.data.db.entities.NewsEntity

class NewsRepository(context: Context) {
    private val db by lazy {
        Room.databaseBuilder(context, NewsDatabase::class.java, "NewsDB")
            .allowMainThreadQueries()
            .build()
    }
    private val newsDAO by lazy {
        db.getDao()
    }

    suspend fun getDetails(newsId: Long): New = newsDAO.getDetails(newsId)

    suspend fun getNews(): List<New> {
        return newsDAO.getNews()
    }

    suspend fun addNews(news: NewsEntity) {
        newsDAO.add(news)
    }
}
