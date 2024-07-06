package ru.itis.summer24.commandproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.itis.summer24.commandproject.databinding.FragmentLandmarksBinding
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
class LandmarksFragment : Fragment(R.layout.fragment_landmarks) {

    private var binding: FragmentLandmarksBinding? = null
    private var adapter: LandmarksAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLandmarksBinding.bind(view)
        initAdapter()
    }

    // Инициализация адаптера для RecyclerView
    private fun initAdapter() {
        adapter = LandmarksAdapter(
            list = LandmarksRepository.landmarks,
            glide = Glide.with(this@LandmarksFragment),
            onClick = { landmark ->
                // Переход на экран с подробной информацией о достопримечательности
                val bundle = Bundle().apply {
                    putInt("landmark_id", landmark.id)
                }
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                findNavController().navigate(R.id.action_landmarksFragment_to_dostFragment, bundle) //ВМЕСТО DOST ПОМЕНЯТЬ!!!
           //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        )

        // Установка адаптера и менеджера компоновки для RecyclerView
        binding?.apply {
            rvLandmarks.adapter = adapter
            rvLandmarks.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    // Метод, который выполняется при уничтожении фрагмента
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}
