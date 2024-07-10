package ru.itis.summer24.commandproject.ui
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import ru.itis.summer24.commandproject.databinding.ItemLandmarkBinding
import ru.itis.summer24.commandproject.models.Landmark

class LandmarksHolder (
    private val binding: ItemLandmarkBinding,
    private val glide: RequestManager,
    private val onClick: (Landmark) -> Unit,
    private val currentLanguage: String,
) : RecyclerView.ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(landmark: Landmark) {
        binding.run {
            if (currentLanguage == "en") {
                tvName.text = landmark.name
                tvCity.text = landmark.city
                tvShortInformation.text = landmark.shortInformation
            } else if(currentLanguage == "ru"){
                tvName.text = landmark.runame
                tvCity.text = landmark.rucity
                tvShortInformation.text = landmark.rushortInformation
            }

            glide
                .load(landmark.imageUrl)
                .apply(requestOptions)
                .into(ivLandmark)

            root.setOnClickListener {
                onClick.invoke(landmark)
            }
        }
    }
}