package com.example.mobiletechnicaltest.ui.plp.usecase

import com.example.mobiletechnicaltest.domain.model.Product
import com.example.mobiletechnicaltest.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductListUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    fun getAllProducts(): Flow<List<Product>> = repository.getProducts()
}