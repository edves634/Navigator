package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test.databinding.FragmentViewpagerBinding
import com.google.android.material.tabs.TabLayoutMediator

// Фрагмент, содержащий ViewPager2 с TabLayout для отображения вкладок
class ViewPager : Fragment() {
    // View Binding (используется lateinit для упрощения)
    private lateinit var binding: FragmentViewpagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализация View Binding
        binding = FragmentViewpagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Создание и установка адаптера для ViewPager2
        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        // Связывание TabLayout с ViewPager2
        // TabLayoutMediator синхронизирует вкладки и контент ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Конфигурация вкладки для каждой позиции
            tab.text = when(position) {
                0 -> "Table 1"
                else -> "Table 2"
            }
        }.attach() // Привязка mediator к компонентам
    }
}

// Адаптер для ViewPager2, управляющий фрагментами во вкладках
class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // Количество вкладок/страниц
    override fun getItemCount(): Int = 2

    // Создание фрагмента для конкретной позиции
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TableFragment.newInstance("Table 1") // Первая вкладка
            else -> TableFragment.newInstance("Table 2") // Вторая вкладка
        }
    }
}