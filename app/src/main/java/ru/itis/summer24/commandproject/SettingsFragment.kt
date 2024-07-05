package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import ru.itis.summer24.commandproject.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        changeTheme()
    }

    private fun changeTheme(){
        val currentTheme = getCurrentTheme()

        binding?.switchTheme?.text = if (currentTheme == AppCompatDelegate.MODE_NIGHT_YES) {
            "Dark Mode"
        } else {
            "Light Mode"
        }

        binding?.switchTheme?.setOnClickListener{
            val newTheme = if (currentTheme == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.MODE_NIGHT_NO
            } else {
                AppCompatDelegate.MODE_NIGHT_YES
            }
            AppCompatDelegate.setDefaultNightMode(newTheme)
            binding?.switchTheme?.text = if (newTheme == AppCompatDelegate.MODE_NIGHT_YES) {
                "Dark Mode"
            } else {
                "Light Mode"
            }
        }
    }

    private fun getCurrentTheme(): Int {
        return AppCompatDelegate.getDefaultNightMode()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}