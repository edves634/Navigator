package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Фрагмент для отображения домашнего экрана приложения
class HomeFragment : Fragment() {

    /**
     * Создает и возвращает иерархию представлений для фрагмента
     *
     * @param inflater Сервис для преобразования XML-макета в View-объекты
     * @param container Родительский ViewGroup для прикрепления фрагмента
     * @param savedInstanceState Сохраненное состояние фрагмента (если есть)
     * @return Корневое View фрагмента
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Преобразование XML-макета в View-объект
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}