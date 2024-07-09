package ru.itis.summer24.commandproject


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.ItemLandmarksBinding

//Этот файл отвечает за отображение списка элементов в RecyclerView.

class LandmarksAdapter (
        private var list: List<Landmark>,
        private val glide: RequestManager,
        private val onClick: (Landmark) -> Unit
    ) : RecyclerView.Adapter<LandmarksHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarksHolder {
            val binding = ItemLandmarksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return LandmarksHolder(binding, glide, onClick)
        }

        override fun onBindViewHolder(holder: LandmarksHolder, position: Int) {
            holder.onBind(list[position])
        }

        override fun getItemCount(): Int = list.size

        fun updateDataset(newList: List<Landmark>) {
            list = newList
            notifyDataSetChanged()
        }
    }
