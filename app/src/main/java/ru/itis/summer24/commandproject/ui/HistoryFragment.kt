package ru.itis.summer24.commandproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import ru.itis.summer24.commandproject.R
import ru.itis.summer24.commandproject.databinding.FragmentHistoryBinding
import ru.itis.summer24.commandproject.ui.app


class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding

    val viewModel by lazy {
        val factory = HistoryViewModel.Factory(app.mainModule.repository)
        ViewModelProvider(this, factory).get(HistoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val historyAdapter = HistoryAdapter(
            onCardClick = {
                findNavController().navigate(
                    resId = R.id.action_historyFragment_to_detailsFragment,
                    DetailFragment.createBundle(it)
                )
            })

        val gridLayout = GridLayoutManager(
            context,
            1,
            GridLayoutManager.VERTICAL,
            false
        )

        viewModel.cart.observe(viewLifecycleOwner) {
            historyAdapter.list = it
        }
    }
}
