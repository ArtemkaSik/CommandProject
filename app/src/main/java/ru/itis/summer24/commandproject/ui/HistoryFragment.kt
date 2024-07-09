package ru.itis.summer24.commandproject.ui

import LandmarksRepository
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.summer24.commandproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.itis.summer24.commandproject.MainFragmentActivity
import ru.itis.summer24.commandproject.databinding.FragmentHistoryBinding



class HistoryFragment : Fragment(R.layout.fragment_history) {
    private var binding: FragmentHistoryBinding? = null
    private var adapter: HistoryAdapter? = null
    private lateinit var database: LandmarksRepository
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)
        database = (requireActivity() as MainFragmentActivity).database
        initAdapter()
    }
    private fun initAdapter() {
        scope.launch {
            binding?.run {
                adapter = HistoryAdapter(
                    list = database.getHistory(),
                    glide = Glide.with(this@HistoryFragment),
                    onClick = {
                        findNavController().navigate(
                            resId = R.id.action_historyFragment_to_historylandmarkFragment,
                            args = HistoryLandmarksFragment.createBundle(it.id)
                        )
                    }
                )
                rvHistory.adapter = adapter
                rvHistory.layoutManager = LinearLayoutManager(requireContext())

            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}