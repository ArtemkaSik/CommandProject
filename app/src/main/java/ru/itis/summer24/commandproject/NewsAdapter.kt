package ru.itis.summer24.commandproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemNewsBinding
import ru.itis.summer24.commandproject.models.New

class NewsAdapter(
    private var list: List<New>,
    private val glide: RequestManager,
    private val onClick: (New) -> Unit,
) : RecyclerView.Adapter<NewsHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsHolder = NewsHolder(
        binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<New>) {
        list = newList
        notifyDataSetChanged()
    }
}
