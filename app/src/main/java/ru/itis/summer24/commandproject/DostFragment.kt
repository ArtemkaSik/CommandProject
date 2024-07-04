package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summer24.commandproject.databinding.FragmentDostBinding
import ru.itis.summer24.commandproject.databinding.FragmentSettingsBinding

class DostFragment : Fragment(R.layout.fragment_dost) {

    private var binding: FragmentDostBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDostBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}