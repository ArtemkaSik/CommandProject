package ru.itis.summer24.commandproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summer24.commandproject.databinding.FragmentLandmarksBinding
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.summer24.commandproject.R

class LandmarksFragment : Fragment(R.layout.fragment_landmarks) {
    private var binding: FragmentLandmarksBinding? = null
    private var adapter: LandmarksAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLandmarksBinding.bind(view)
        initAdapter()
    }
    private fun initAdapter() {
        binding?.run {
            adapter = LandmarksAdapter(
                list = app.mainModule.repository.getLandmarks(),
                glide = Glide.with(this@LandmarksFragment),
                onClick = {
                    findNavController().navigate(
                        R.id.action_landmarksFragment_to_detailsFragment,
                        DetailFragment.createBundle(it.id)
                    )
                }
            )
            rvLandmarks.adapter = adapter
            rvLandmarks.layoutManager = LinearLayoutManager(requireContext())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}