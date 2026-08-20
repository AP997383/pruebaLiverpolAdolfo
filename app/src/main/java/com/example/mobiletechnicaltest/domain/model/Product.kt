package com.example.mobiletechnicaltest.domain.model

import com.example.mobiletechnicaltest.data.remote.dto.ProductResponse

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
fun ProductResponse.toProduct(): Product {
    return Product(
        id = this.id,
        title = this.title,
        price = this.price,
        description = this.description,
        category = this.category,
        imageUrl = this.image,
        rating = this.rating.rate,
        ratingCount = this.rating.count
    )
}