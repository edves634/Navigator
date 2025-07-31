package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.test.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// Главная Activity приложения, контейнер для фрагментов
class MainActivity : AppCompatActivity() {

    // View Binding для доступа к элементам UI
    private lateinit var binding: ActivityMainBinding

    // Контроллер навигации для управления переходами между фрагментами
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Настройка Navigation Component
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Связываем BottomNavigation с контроллером навигации
        binding.bottomNavigation.setupWithNavController(navController)

        // Слушатель изменений текущего фрагмента
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                // Скрываем нижнюю навигацию на экранах авторизации
                R.id.splashFragment,
                R.id.loginFragment,
                R.id.registerFragment -> hideBottomNav()

                // Показываем навигацию на основных экранах
                else -> showBottomNav()
            }
        }

        // Настройка кастомной обработки кнопки "Назад"
        setupBackPressHandler()
    }

    /**
     * Кастомная обработка нажатия кнопки "Назад"
     * Определяет поведение для разных точек входа
     */
    private fun setupBackPressHandler() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Текущий фрагмент
                val currentDestination = navController.currentDestination?.id

                // Корневые фрагменты нижнего меню
                val rootFragments = setOf(
                    R.id.searchFragment,
                    R.id.favoritesFragment,
                    R.id.responsesFragment,
                    R.id.profileFragment
                )

                when {
                    // Если находимся в корневом фрагменте - переход на Home
                    rootFragments.contains(currentDestination) -> {
                        navController.navigate(R.id.action_global_home)
                    }

                    // На домашнем экране - переход на Splash
                    currentDestination == R.id.homeFragment -> {
                        navController.navigate(R.id.action_global_splash)
                    }

                    // На Splash экране - выход из приложения
                    currentDestination == R.id.splashFragment -> {
                        finish()
                    }

                    // Во всех остальных случаях - стандартное поведение
                    else -> {
                        if (!navController.popBackStack()) {
                            finish()
                        }
                    }
                }
            }
        }
        // Регистрация обработчика
        onBackPressedDispatcher.addCallback(this, callback)
    }

    // Показать нижнюю навигацию
    private fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    // Скрыть нижнюю навигацию
    private fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
    }
}