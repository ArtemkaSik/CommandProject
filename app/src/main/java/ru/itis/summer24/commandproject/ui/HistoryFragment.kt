package ru.itis.summer24.commandproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.summer24.commandproject.R

import ru.itis.summer24.commandproject.databinding.FragmentHistoryBinding
import ru.itis.summer24.commandproject.models.Landmark


class HistoryFragment : Fragment(R.layout.fragment_history) {
    private var binding: FragmentHistoryBinding? = null
    private var adapter: HistoryAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        binding?.run {
            adapter = HistoryAdapter(
                list = app.mainModule.repository.getHistory(),
                glide = Glide.with(this@HistoryFragment),
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_historyFragment_to_detailsFragment,
                        args = DetailFragment.createBundle(it.id)
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