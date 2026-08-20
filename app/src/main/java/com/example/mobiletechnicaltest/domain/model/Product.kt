package com.example.mobiletechnicaltest.domain.model

data class Product(
    val id: Int=0,
    val title: String="",
    val price: Double=0.0,
    val description: String="Sin descripción",
    val category: String="",
    val imageUrl: String="",
    val rating: Double=0.0,
    val ratingCount: Int=0
)
