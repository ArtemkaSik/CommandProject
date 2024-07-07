package ru.itis.summer24.commandproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.R
import ru.itis.summer24.commandproject.databinding.FragmentDetailBinding
import ru.itis.summer24.commandproject.ui.app

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    val landmarkId by lazy { arguments?.getLong(ID, 0L) ?: 0L }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)


        app.mainModule.repository.getDetails(landmarkId).observe(viewLifecycleOwner) {
            val landmark = it
            binding.run {
                tvCity.text = it.city
                tvLongInformation.text = it.longInformation
                tvName.text = it.name

                Glide
                    .with(view)
                    .load(it.imageUrl)
                    .into(ivLandmark)
            }

        }
    }
    companion object {
        private const val ID = "ID"
        fun createBundle(id: Long): Bundle {
            val bundle = Bundle()
            bundle.putLong(ID, id)
            return bundle
        }

    }

}