package com.example.tercerparcial.domain.repository

import com.example.tercerparcial.domain.model.Plan

interface Planrepository {
    fun getPlans(): List<Plan>
}