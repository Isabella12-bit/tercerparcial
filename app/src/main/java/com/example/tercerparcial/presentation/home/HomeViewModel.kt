package com.example.tercerparcial.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tercerparcial.domain.usecase.GetPlansUseCase
import com.example.tercerparcial.domain.model.Plan

class HomeViewModel(private val getPlansUseCase: GetPlansUseCase) : ViewModel() {
    val plans: List<Plan> = getPlansUseCase()
}

class HomeViewModelFactory(private val useCase: GetPlansUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
