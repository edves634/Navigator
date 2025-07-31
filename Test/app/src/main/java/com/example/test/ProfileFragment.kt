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
    // Переменная для привязки представлений (View Binding)
    private var _binding: FragmentProfileBinding? = null

    // Геттер для безопасного доступа к привязке (только между onCreateView и onDestroyView)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация привязки данных через Data Binding
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        // Возвращаем корневое view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Обработчик клика по кнопке выхода
//        binding.logoutButton.setOnClickListener {
//            // Использование глобального действия для возврата к графу авторизации
//            // action_global_auth_nav_graph - ID глобального перехода, объявленного в навигационном графе
//            findNavController().navigate(R.id.action_global_auth_nav_graph)
//        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на привязку при уничтожении view для предотвращения утечек памяти
        _binding = null
    }
}