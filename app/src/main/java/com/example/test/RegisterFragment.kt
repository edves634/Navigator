package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentRegisterBinding

// Фрагмент для экрана регистрации пользователя
class RegisterFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам layout
    private var _binding: FragmentRegisterBinding? = null
    // Не-null версия binding (используется только когда view существует)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        // inflate() создает экземпляр binding класса для этого фрагмента
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Возвращаем корневое view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Здесь происходит настройка UI после создания view
        // Системная кнопка "Назад" обрабатывается Navigation Component автоматически

        // Обработчик клика по кнопке регистрации
        binding.btnRegister.setOnClickListener {

            // Пример проверки (заглушка)
            if (isRegistrationValid()) {
                // Успешная регистрация
                // Навигация к основному экрану через Navigation Component
                findNavController().navigate(R.id.action_register_to_main)
            } else {
                // Обработка ошибки регистрации
                Toast.makeText(requireContext(), "Проверьте введенные данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Вспомогательная функция для валидации данных (заглушка)
    private fun isRegistrationValid(): Boolean {

        return true // Всегда возвращает true в этом примере
    }

    // Очистка binding при уничтожении view
    override fun onDestroyView() {
        super.onDestroyView()
        // Обнуляем binding для предотвращения утечек памяти
        _binding = null
    }
}