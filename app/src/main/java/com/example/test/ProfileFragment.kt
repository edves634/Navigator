package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentProfileBinding

// Фрагмент для отображения профиля пользователя
class ProfileFragment : Fragment() {

    // Привязка для View Binding (доступна только между onCreateView и onDestroyView)
    private var _binding: FragmentProfileBinding? = null

    // Безопасный геттер для привязки (возвращает non-null значение только когда view существует)
    private val binding get() = _binding!!

    // Создание view фрагмента
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 1. Инициализация View Binding
        //    (преобразует XML-макет в иерархию view-компонентов)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        // 2. Возвращаем корневой элемент макета фрагмента
        return binding.root
    }

    // Настройка view после ее создания
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 3. Обработка нажатия кнопки выхода
        binding.logoutButton.setOnClickListener {
            // Используем Navigation Component для перехода к потоку аутентификации
            // R.id.action_to_auth_flow - ID действия из графа навигации
            findNavController().navigate(R.id.action_to_auth_flow)
        }

    }

    // Очистка ресурсов при уничтожении view
    override fun onDestroyView() {
        super.onDestroyView()

        // 4. Обнуляем ссылку на привязку для предотвращения утечек памяти
        //    (поскольку жизненный цикл view закончился)
        _binding = null
    }

}