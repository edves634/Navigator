package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentFavoritesBinding

// Фрагмент для отображения избранного контента
class FavoritesFragment : Fragment() {

    // Переменная для View Binding (с поддержкой null)
    private var _binding: FragmentFavoritesBinding? = null

    // Свойство для безопасного доступа к привязке (non-null)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Инициализация View Binding
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        // Возвращаем корневое view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Обработчик клика по кнопке перехода к деталям
        binding.btnDetailsFavorites.setOnClickListener {
            // Навигация к фрагменту с деталями через Navigation Component
            findNavController().navigate(R.id.detailsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на binding для предотвращения утечек памяти
        _binding = null
    }
}