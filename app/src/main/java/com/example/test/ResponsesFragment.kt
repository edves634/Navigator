package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentResponsesBinding

// Фрагмент для отображения экрана "Responses" (возможно, откликов или ответов)
class ResponsesFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам UI
    private var _binding: FragmentResponsesBinding? = null
    // Non-null версия binding (используется только когда view существует)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding для этого фрагмента
        _binding = FragmentResponsesBinding.inflate(inflater, container, false)
        // Возвращаем корневое view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка UI и обработчиков событий после создания view

        // Обработчик клика по кнопке перехода к ViewPager
        binding.bntViewPager.setOnClickListener {
            // Навигация к фрагменту, связанному с ID "view_pager" в графе навигации
            // Используется Navigation Component для безопасной навигации
            findNavController().navigate(R.id.view_pager)
        }

        // Обработчик клика по кнопке перехода к Nested Flow
        binding.bntNestedFlow.setOnClickListener {
            // Навигация к фрагменту, связанному с ID "nested_flow" в графе навигации
            // Переход без передачи параметров
            findNavController().navigate(R.id.nested_flow)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на binding при уничтожении view
        // Предотвращает утечки памяти
        _binding = null
    }
}