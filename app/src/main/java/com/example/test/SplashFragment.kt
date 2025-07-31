package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentSplashBinding

// Фрагмент экрана-заставки (Splash Screen)
class SplashFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам UI
    private var _binding: FragmentSplashBinding? = null

    // Non-null версия binding (используется только при существующем view)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        // Создает экземпляр класса Binding для splash screen layout
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        // Возвращает корневой view фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка UI и обработчиков событий после создания view

        // Обработчик клика по кнопке "Login"
        binding.startBtnLogin.setOnClickListener {
            // Навигация к потоку аутентификации (Auth Flow)
            // Используется действие (action) из графа навигации
            findNavController().navigate(R.id.action_to_auth_flow)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на binding при уничтожении view
        // Критически важно для предотвращения утечек памяти
        _binding = null
    }
}