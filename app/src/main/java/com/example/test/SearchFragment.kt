package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentSearchBinding

// Фрагмент для экрана поиска
class SearchFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам UI
    private var _binding: FragmentSearchBinding? = null

    // Non-null версия binding (используется только при существующем view)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        // Создает экземпляр класса Binding для этого layout
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        // Возвращает корневой view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка UI и обработчиков событий после создания view

        // Обработчик клика по основной кнопке поиска
        binding.btnSearch.setOnClickListener {
            // Навигация к фрагменту с ID "action_to_nested_flow"
            // Используется Navigation Component для перехода
            findNavController().navigate(R.id.action_to_nested_flow)
        }

        // Обработчик клика по кнопке перехода к деталям поиска
        binding.bntSearchDetails.setOnClickListener {
            // Навигация напрямую к фрагменту с ID "detailsFragment"
            findNavController().navigate(R.id.detailsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на binding при уничтожении view
        _binding = null
    }
}