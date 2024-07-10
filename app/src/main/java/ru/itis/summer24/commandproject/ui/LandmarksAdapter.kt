package ru.itis.summer24.commandproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemLandmarkBinding
import ru.itis.summer24.commandproject.models.Landmark

class LandmarksAdapter(
    private var list: List<Landmark>,
    private val glide: RequestManager,
    private val onClick: (Landmark) -> Unit,
    private val currentLanguage: String,
) : RecyclerView.Adapter<LandmarksHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LandmarksHolder = LandmarksHolder(
        binding = ItemLandmarkBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
        currentLanguage = currentLanguage,
    )

    override fun onBindViewHolder(holder: LandmarksHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<Landmark>) {
        list = newList
        notifyDataSetChanged()
    }
}