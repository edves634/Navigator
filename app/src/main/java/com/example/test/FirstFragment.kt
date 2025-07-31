package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentFirstBinding

// Фрагмент первого экрана приложения
class FirstFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам UI
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        // Возвращаем корневое представление фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Обработка клика по кнопке перехода
        binding.btnGoToSecond.setOnClickListener {
            // Навигация на второй фрагмент с использованием Navigation Component
            findNavController().navigate(R.id.action_to_second)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка привязки для предотвращения утечек памяти
        _binding = null
    }
}