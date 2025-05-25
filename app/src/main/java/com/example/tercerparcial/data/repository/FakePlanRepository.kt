package com.example.tercerparcial.data.repository

import com.example.tercerparcial.domain.model.Plan
import com.example.tercerparcial.domain.repository.Planrepository

class FakePlanRepository : Planrepository {
    override fun getPlans(): List<Plan> {
        return listOf(
            Plan("Plan FLEX 5", 270, 199, 5, listOf("Llamadas y SMS ilimitados", "Hotspot", "Redes Sociales ilimitadas", "CO2 Negativo")),
            Plan("Plan FLEX 8", 370, 299, 8, listOf("Llamadas y SMS ilimitados", "Hotspot", "Redes Sociales ilimitadas", "CO2 Negativo")),
            Plan("Plan FLEX 10", 470, 399, 10, listOf("Llamadas y SMS ilimitados", "Hotspot", "Redes Sociales ilimitadas", "CO2 Negativo"))
        )
    }
}
