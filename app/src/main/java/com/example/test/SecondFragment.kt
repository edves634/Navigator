package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentSecondBinding

// Второй фрагмент в потоке навигации
class SecondFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам UI
    private var _binding: FragmentSecondBinding? = null
    // Non-null версия binding (используется только при существующем view)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        // Создает экземпляр класса Binding для этого layout
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Возвращает корневой view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка UI и обработчиков событий после создания view

        // Обработчик клика по кнопке возврата
        binding.btnBackToFirst.setOnClickListener {
            // Возврат к предыдущему фрагменту в стеке навигации
            // popBackStack() удаляет текущий фрагмент из стека
            // и возвращает к предыдущему (в данном случае - FirstFragment)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на binding при уничтожении view
        // Критически важно для предотвращения утечек памяти
        _binding = null
    }
}