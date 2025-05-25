package com.example.tercerparcial.domain.usecase

import com.example.tercerparcial.domain.model.Plan
import com.example.tercerparcial.domain.repository.Planrepository

class GetPlansUseCase(private val repository: Planrepository) {
    operator fun invoke(): List<Plan> = repository.getPlans()
}
