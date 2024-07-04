package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summer24.commandproject.databinding.FragmentHistoryBinding
import ru.itis.summer24.commandproject.databinding.FragmentSettingsBinding

class HistoryFragment : Fragment(R.layout.fragment_history){

    private var binding: FragmentHistoryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}