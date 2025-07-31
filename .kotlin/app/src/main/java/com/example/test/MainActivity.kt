package com.example.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.test.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Находим BottomNavigationView
        bottomNavigation = findViewById(R.id.bottom_navigation)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Упрощенный вариант (без let):
        binding.bottomNavigation.setupWithNavController(navController)

        // Связываем BottomNavigation с NavController
        bottomNavigation.setupWithNavController(navController)

        // Слушатель для скрытия/показа BottomNavigation
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment,
                R.id.profileFragment,
                R.id.registerFragment
                    -> {
                    // Скрываем BottomNavigation на этих экранах
                    bottomNavigation.visibility = View.GONE
                }

                else -> {
                    // Показываем BottomNavigation на основных экранах
                    bottomNavigation.visibility = View.VISIBLE
                }
            }
        }
    }
}
