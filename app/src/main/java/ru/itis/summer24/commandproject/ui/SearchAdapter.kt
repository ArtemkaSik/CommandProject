package ru.itis.summer24.commandproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemLandmarkBinding
import ru.itis.summer24.commandproject.models.Landmark

class SearchAdapter(
    private var list: List<Landmark>,
    private val glide: RequestManager,
    private val onClick: (Landmark) -> Unit,
    private val currentLanguage: String,
) : RecyclerView.Adapter<HistoryHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryHolder = HistoryHolder(
        binding = ItemLandmarkBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
        currentLanguage = currentLanguage,
    )

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}