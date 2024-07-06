package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment(R.layout.fragment_history) {

    private var binding: FragmentHistoryBinding? = null
    private var adapter: HistoryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

        initAdapter()
    }

    private fun initAdapter(){
        adapter = HistoryAdapter(
            list = HistoryRepository.sights,
            glide = Glide.with(this),
            onClick = { sightId ->
                val bundle = Bundle().apply {
                    putInt("sight_id", sightId)
                }
                findNavController().navigate(
                    R.id.action_historyFragment_to_detailFragment,
                    bundle
                )
            }

        )

        binding?.apply {
            rvSight.adapter = adapter
            rvSight.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
