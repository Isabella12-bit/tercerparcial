package com.example.tercerparcial.domain.model

data class Plan(
    val name: String,
    val oldPrice: Int,
    val newPrice: Int,
    val dataGB: Int,
    val features: List<String>
)