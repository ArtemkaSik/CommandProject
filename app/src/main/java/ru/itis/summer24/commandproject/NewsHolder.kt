package ru.itis.summer24.commandproject

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import ru.itis.summer24.commandproject.databinding.ItemNewsBinding
import ru.itis.summer24.commandproject.models.New

class NewsHolder (
    private val binding: ItemNewsBinding,
    private val glide: RequestManager,
    private val onClick: (New) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(news: New) {
        binding.run {
            tvNews.text = news.name
            tvDescription.text = news.description
            textView.text = news.city

            glide
                .load(news.url)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(news)
            }
        }
    }
}
