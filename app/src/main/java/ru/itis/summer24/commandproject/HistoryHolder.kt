package ru.itis.summer24.commandproject

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemHistoryBinding

class HistoryHolder(
    private val glide: RequestManager,
    private val binding: ItemHistoryBinding,
    private val onClick: (Int) -> Unit
) : ViewHolder(binding.root) {
    fun onBind(history: History) {
        binding.run {
            tvHistory.text = history.name
            tvCity.text = history.city

            glide
                .load(history.url)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivImage)

            root.setOnClickListener{
                onClick.invoke(history.id)
            }
        }
    }
}