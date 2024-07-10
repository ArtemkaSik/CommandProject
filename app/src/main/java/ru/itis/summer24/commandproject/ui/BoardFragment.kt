package ru.itis.summer24.commandproject

import NewsRepository
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summer24.commandproject.databinding.FragmentBoardBinding
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.itis.summer24.commandproject.data.db.News
import ru.itis.summer24.commandproject.data.db.entities.NewsEntity

class BoardFragment : Fragment(R.layout.fragment_board) {
    private var binding: FragmentBoardBinding? = null
    private var adapter: NewsAdapter? = null
    private lateinit var database2: NewsRepository
    private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoardBinding.bind(view)
        database2 = (requireActivity() as MainFragmentActivity).database2
        initAdapter()
    }

    private fun initAdapter() {
        scope.launch {
            binding?.run {
                adapter = NewsAdapter(
                    list = database2.getNews(),
                    glide = Glide.with(this@BoardFragment),
                    onClick = {
                        findNavController().navigate(
                            R.id.action_boardFragment_to_detailFragment,
                            DetailFragment.createBundle(it.id)
                        )
                    },
                    currentLanguage = resources.configuration.locales[0].language
                )
                rvNews.adapter = adapter
                rvNews.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ID = "ID"

        fun createBundle(id: Long): Bundle {
            return Bundle().apply { putLong(ID, id) }
        }
    }

}
