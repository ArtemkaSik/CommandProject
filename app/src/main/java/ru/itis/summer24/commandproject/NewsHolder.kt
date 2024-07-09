package ru.itis.summer24.commandproject

import androidx.appcompat.view.menu.MenuView
import ru.itis.summer24.commandproject.databinding.ItemNewsBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.Request

class NewsHolder(
    private val binding: ItemNewsBinding,
    private val glide: RequestManager,
    private val onClick: (News) -> Unit,
) : ViewHolder(binding.root){

    fun onBind(news: News){
        binding.run {
            tvNews.text = news.name
            tvDescription.text = news.description
            textView.text = news.city

            glide
                .load(news.url)
                .into(ivImage)

            root.setOnClickListener{
                onClick.invoke(news)
            }
        }
    }
}

