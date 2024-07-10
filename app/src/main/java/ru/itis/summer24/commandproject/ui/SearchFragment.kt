package ru.itis.summer24.commandproject.ui

import LandmarksRepository
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summer24.commandproject.databinding.FragmentSearchBinding
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.summer24.commandproject.MainFragmentActivity
import ru.itis.summer24.commandproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.itis.summer24.commandproject.data.db.Landmarks
import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity
import com.google.android.material.snackbar.Snackbar
import ru.itis.summer24.commandproject.ui.LandmarkFragment.Companion

class SearchFragment : Fragment(R.layout.fragment_search) {
    private var binding: FragmentSearchBinding? = null
    private var adapter: SearchAdapter? = null
    private val string by lazy { arguments?.getString(SearchFragment.STRING, "")?.toUpperCase() ?: "" }
    private lateinit var database: LandmarksRepository
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    val landmarksList: List<LandmarkEntity> = Landmarks.testLandmarks

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        database = (requireActivity() as MainFragmentActivity).database
        initAdapter()
    }

    private fun initAdapter() {
        scope.launch {
            binding?.run {
                searchStr.text = string.lowercase()
                back.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_searchFragment_to_landmarksFragment
                    )
                }
                adapter = SearchAdapter(
                    list = database.searchItems(string),
                    glide = Glide.with(this@SearchFragment),
                    onClick = {
                        findNavController().navigate(
                            R.id.action_searchFragment_to_landmarkFragment,
                            LandmarkFragment.createBundle(it.id)
                        )
                    },
                    currentLanguage = resources.configuration.locales[0].language
                )
                rvSearch.adapter = adapter
                rvSearch.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        private const val STRING = "STRING"
        private const val ID = "ID"

        fun idBundle(id: Long): Bundle {
            return Bundle().apply { putLong(ID, id) }
        }
        fun stringBundle(string: String): Bundle {
            return Bundle().apply { putString(STRING, string) }
        }
    }
}