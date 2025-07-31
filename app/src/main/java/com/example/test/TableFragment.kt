package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.databinding.FragmentTableBinding

// Фрагмент для отображения таблицы с заголовком
class TableFragment : Fragment() {
    // View Binding переменная (используется lateinit вместо nullable)
    private lateinit var binding: FragmentTableBinding

    // Компаньон-объект для создания экземпляра фрагмента с аргументами
    companion object {
        // Фабричный метод для создания фрагмента с параметрами
        fun newInstance(title: String) = TableFragment().apply {
            // Создание Bundle для передачи параметров
            arguments = Bundle().apply {
                // Сохранение заголовка в аргументах
                putString("title", title)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        binding = FragmentTableBinding.inflate(inflater, container, false)
        // Возврат корневого view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка заголовка из аргументов

        binding.title.text = arguments?.getString("title") ?: "Table"
    }
}