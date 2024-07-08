package ru.itis.summer24.commandproject

import LandmarksRepository
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.summer24.commandproject.databinding.ActivityFragmentMainBinding


class MainFragmentActivity : AppCompatActivity() {

    private var binding: ActivityFragmentMainBinding? = null
    lateinit var database: LandmarksRepository
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
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
        (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController
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