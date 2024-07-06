package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.summer24.commandproject.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var binding: FragmentDetailBinding? = null
    private var glide: RequestManager? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        glide = Glide.with(this)

        val sightId = arguments?.getInt("sight_id") ?: -1
        val sight = HistoryRepository.sights.find { it.id == sightId }

        binding?.apply{
            sight?.let {
                tvTitle.text = it.name
                glide
                    ?.load(it.url)
                    ?.error(R.drawable.ic_error)
                    ?.placeholder(R.drawable.ic_loading)
                    ?.into(ivImage)
                tvCity.text = it.city.toString()
                tvDescription.text = it.description
            }

            sendTextBtn.setOnClickListener{
                findNavController().navigate(
                    resId = R.id.action_detailFragment_to_historyFragment
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}