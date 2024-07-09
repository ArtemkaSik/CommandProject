package ru.itis.summer24.commandproject

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import ru.itis.summer24.commandproject.databinding.FragmentSettingsBinding
import java.util.Locale


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null
    private lateinit var spinner: Spinner

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        changeTheme()
        changeLanguage()
        checkSavedLanguage()
    }

    private fun changeTheme(){
        val currentTheme = getCurrentTheme()

        binding?.switchTheme?.text = if (currentTheme == AppCompatDelegate.MODE_NIGHT_YES) {
            "Dark Theme"
        } else {
            "Light Theme"
        }

        binding?.switchTheme?.setOnClickListener{
            val newTheme = if (currentTheme == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.MODE_NIGHT_NO
            } else {
                AppCompatDelegate.MODE_NIGHT_YES
            }
            AppCompatDelegate.setDefaultNightMode(newTheme)
            saveCurrentTheme(newTheme)
            binding?.switchTheme?.text = if (newTheme == AppCompatDelegate.MODE_NIGHT_YES) {
                "Dark Theme"
            } else {
                "Light Theme"
            }
        }
    }

    private fun getCurrentTheme(): Int {
        return AppCompatDelegate.getDefaultNightMode()
    }

    private fun saveCurrentTheme(theme: Int) {
        val sharedPreferences = requireContext().getSharedPreferences("AppTheme", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("theme", theme)
        editor.apply()
    }

    private fun changeLanguage() {
        spinner = binding?.spinner!!

        val languages = arrayOf("Русский", "English")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (languages[position]) {
                    "Русский" -> setLocale("ru")
                    "English" -> setLocale("en")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    // Функция для изменения языка приложения
    private fun setLocale(language: String) {
        val locale = Locale(language.lowercase())
        Locale.setDefault(locale)
        val resources: Resources = resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Save selected language
        val sharedPreferences = requireContext().getSharedPreferences("AppLanguage", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("language", language)
        editor.apply()
    }

    private fun checkSavedLanguage() {
        val sharedPreferences = requireContext().getSharedPreferences("AppLanguage", Context.MODE_PRIVATE)
        val savedLanguage = sharedPreferences.getString("language", "en")

        if (savedLanguage != null) {
            val position = when (savedLanguage) {
                "ru" -> 0
                "en" -> 1
                else -> 0
            }
            spinner.setSelection(position)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}