package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.databinding.FragmentDetailsBinding

// Фрагмент для отображения детальной информации об избранном
class DetailsFavorites : Fragment() {
    // Null-safe переменная для привязки представлений
    private var _binding: FragmentDetailsBinding? = null

    // Публичное свойство для доступа к привязке (только для чтения)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Инициализация привязки представлений с использованием Data Binding
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        // Возврат корневого элемента макета фрагмента
        return binding.root
    }

    // Очистка ссылки на привязку при уничтожении представления
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}