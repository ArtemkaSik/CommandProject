package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var binding: FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val newsId = arguments?.getInt("news_id") ?: return
        val news = NewsRepository.news_.find { it.id == newsId } ?: return

        binding?.run {
            Glide.with(this@DetailFragment)
                .load(news.url)
                .into(detailImageView)
            detailTitleTextView.text = news.name
            detailDesTextView.text = news.description
            detailCityTextView.text = news.city

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
