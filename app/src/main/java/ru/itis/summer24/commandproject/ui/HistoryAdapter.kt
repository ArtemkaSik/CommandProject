package ru.itis.summer24.commandproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.R
import ru.itis.summer24.commandproject.databinding.ItemLandmarkBinding
import ru.itis.summer24.commandproject.models.Landmark

class HistoryAdapter(
    val onCardClick: (Long) -> Unit,
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    var list: List<Landmark> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemLandmarkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HistoryViewHolder(val binding: ItemLandmarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(landmark: Landmark) {

            Glide
                .with(binding.root.context)
                .load(landmark.imageUrl)
                .into(binding.ivLandmark)

            binding.tvName.text = landmark.name
            binding.tvCity.text = landmark.city
            binding.tvShortInformation.text = landmark.shortInformation
        }
    }
}