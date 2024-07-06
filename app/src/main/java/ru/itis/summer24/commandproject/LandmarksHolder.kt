package ru.itis.summer24.commandproject

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemLandmarksBinding

//Этот файл отвечает за привязку данных к каждому элементу списка.
class LandmarksHolder (
        private val binding: ItemLandmarksBinding,
        private val glide: RequestManager,
        private val onClick: (Landmarks) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(attraction: Landmarks) {
            binding.apply {
                tvName.text = attraction.name
                tvCity.text = attraction.city
                tvShortDescription.text = attraction.shortDescription
                glide.load(attraction.imageUrl)
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.ic_loading)
                    .into(ivImage)
                root.setOnClickListener {
                    onClick(attraction)
                }
            }
        }
    }
