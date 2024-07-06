package ru.itis.summer24.commandproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemHistoryBinding

class HistoryAdapter(
    private val glide: RequestManager,
    private val list: LiveData<List<History>>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<HistoryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        return HistoryHolder(
            binding = ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onClick = onClick
        )

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.onBind(list[position])
    }

}