package ru.itis.summer24.commandproject

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import LandmarksRepository
import NewsRepository
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.summer24.commandproject.data.db.Landmarks
import ru.itis.summer24.commandproject.databinding.ActivityFragmentMainBinding
import java.util.Locale

import ru.itis.summer24.commandproject.models.Landmark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.itis.summer24.commandproject.data.db.LandmarksDatabase
import ru.itis.summer24.commandproject.data.db.News
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity
import ru.itis.summer24.commandproject.data.db.entities.NewsEntity

class MainFragmentActivity : AppCompatActivity() {

    private var binding: ActivityFragmentMainBinding? = null
    lateinit var database: LandmarksRepository
    lateinit var database2: NewsRepository
    private var controller: NavController? = null
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    val landmarksList: List<LandmarkEntity> = Landmarks.testLandmarks
    val newsList: List<NewsEntity> = News.testNews

    override fun onCreate(savedInstanceState: Bundle?) {
        applySavedTheme()
        applySavedLanguage()
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
        database = LandmarksRepository(this)
        database2 = NewsRepository(this)

        (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController
        sendTable()

        hideSystemUI()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                )
    }

    private fun sendTable() {
        scope.launch {
            if (database.getLandmarks().isEmpty()) {
                landmarksList.forEach { landmark ->
                    database.addLandmark(landmark)
                }
            }
        }
        scope.launch {
            if (database2.getNews().isEmpty()) {
                newsList.forEach { new ->
                    database2.addNews(new)
                }
            }
        }
    }

    private fun applySavedTheme() {
        val sharedPreferences = getSharedPreferences("AppTheme", Context.MODE_PRIVATE)
        val savedTheme = sharedPreferences.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO)
        AppCompatDelegate.setDefaultNightMode(savedTheme)
    }

    private fun applySavedLanguage() {
        val sharedPreferences = getSharedPreferences("AppLanguage", Context.MODE_PRIVATE)
        val savedLanguage = sharedPreferences.getString("language", "en") ?: "en"

        if (savedLanguage != "en") {
            setLocale(savedLanguage)
        }
    }

    private fun setLocale(language: String) {
        val locale = Locale(language.lowercase())
        Locale.setDefault(locale)
        val resources: Resources = resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        controller?.navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
