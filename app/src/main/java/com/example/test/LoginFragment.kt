package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentLoginBinding

// Фрагмент для экрана авторизации (логина)
class LoginFragment : Fragment() {

    // View Binding переменные для безопасного доступа к элементам UI
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!  // Non-null геттер для привязки

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root  // Возвращаем корневое представление фрагмента
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Обработчик кнопки "Регистрация"
        binding.btnRegister.setOnClickListener {
            // Навигация к фрагменту регистрации через Navigation Component
            findNavController().navigate(R.id.action_to_register)
        }

        // Обработчик кнопки "Войти"
        binding.btnLogin.setOnClickListener {

            // переход должен происходить только после успешной аутентификации
            findNavController().navigate(R.id.action_to_main)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Очистка ссылки на binding для предотвращения утечек памяти
        _binding = null
    }

    // Вспомогательная функция для валидации (пример)
    private fun validateCredentials(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.length >= 6
    }

    // Вспомогательная функция для показа ошибок (пример)
    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}