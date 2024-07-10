package ru.itis.summer24.commandproject

import NewsRepository
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.databinding.FragmentDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null
    private val newsId by lazy { arguments?.getLong(ID, 0L) ?: 0L }
    private lateinit var database2: NewsRepository
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        database2 = (requireActivity() as MainFragmentActivity).database2

        binding?.run {
            scope.launch {
                backButton.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_detailFragment_to_boardFragment
                    )
                }
                val news = database2.getDetails(newsId)
                // Получаем текущий язык приложения
                val currentLocale = resources.configuration.locales[0]
                val currentLanguage = currentLocale.language

                // Устанавливаем текст в зависимости от языка
                if (currentLanguage == "en") {
                    detailTitleTextView.text = news.name
                    detailDesTextView.text = news.description
                } else if (currentLanguage == "ru") {
                    detailTitleTextView.text = news.runame
                    detailDesTextView.text = news.rudescription
                }

                detailCityTextView.text = news.date
                Glide.with(view)
                    .load(news.url)
                    .into(detailImageView)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ID = "ID"

        fun createBundle(id: Long): Bundle {
            return Bundle().apply { putLong(ID, id) }
        }
    }
}