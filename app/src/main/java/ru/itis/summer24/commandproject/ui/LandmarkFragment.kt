package ru.itis.summer24.commandproject.ui

import LandmarksRepository
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.R
import ru.itis.summer24.commandproject.databinding.FragmentLandmarkBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.itis.summer24.commandproject.MainFragmentActivity


class LandmarkFragment : Fragment(R.layout.fragment_landmark) {
    private var binding: FragmentLandmarkBinding? = null
    private val landmarkId by lazy { arguments?.getLong(ID, 0L) ?: 0L }
    private lateinit var database: LandmarksRepository
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLandmarkBinding.bind(view)
        database = (requireActivity() as MainFragmentActivity).database

        binding?.run {
            scope.launch {
                back.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_landmarkFragment_to_landmarksFragment
                    )
                }
                visit.setOnClickListener {
                    scope.launch {
                        database.updateVisit(landmarkId)
                    }
                    findNavController().navigate(
                        R.id.action_landmarkFragment_to_landmarksFragment)
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

        fun idBundle(id: Long): Bundle {
            return Bundle().apply { putLong(ID, id) }
        }
    }
}