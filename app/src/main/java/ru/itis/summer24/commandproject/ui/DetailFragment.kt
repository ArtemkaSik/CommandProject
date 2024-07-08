package ru.itis.summer24.commandproject.ui

import LandmarksRepository
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.R
import ru.itis.summer24.commandproject.data.db.LandmarksDAO
import ru.itis.summer24.commandproject.databinding.FragmentDetailBinding
import ru.itis.summer24.commandproject.models.Landmark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.itis.summer24.commandproject.MainFragmentActivity


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null
    private val landmarkId by lazy { arguments?.getLong(ID, 0L) ?: 0L }
    private lateinit var database: LandmarksRepository
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        database = (requireActivity() as MainFragmentActivity).database

        binding?.run {
            scope.launch {
                back.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_detailsFragment_to_landmarksFragment
                    )
                }
                val landmark = database.getDetails(landmarkId)
                    tvName.text = landmark.name
                    tvCity.text = landmark.city
                    tvLongInformation.text = landmark.longInformation
                    Glide.with(view)
                        .load(landmark.imageUrl)
                        .into(ivLandmark)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ID = "ID"

        fun createBundle(id: Long): Bundle {
            return Bundle().apply { putLong(ID, id) }
        }
    }
}