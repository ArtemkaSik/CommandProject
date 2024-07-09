package ru.itis.summer24.commandproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summer24.commandproject.databinding.FragmentBoardBinding

class BoardFragment : Fragment(R.layout.fragment_board) {

    private var binding: FragmentBoardBinding? = null

    private var adapter: NewsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoardBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = NewsAdapter(
                NewsRepository.news_,
                glide = Glide.with(this@BoardFragment),
                onClick = { news ->
                    val bundle = Bundle().apply {
                        putInt("news_id", news.id)
                    }
                    findNavController().navigate(
                        R.id.action_boardFragment_to_detailFragment,
                        DetailFragment.createBundle(it.id)
                    )
                }
            )

            rvNews.adapter = adapter
            rvNews.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}
