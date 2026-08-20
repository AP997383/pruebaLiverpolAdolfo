package com.example.mobiletechnicaltest.ui.pdp.useCase

import com.example.mobiletechnicaltest.domain.model.Product
import com.example.mobiletechnicaltest.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    fun getDetailProduct(id: Int): Flow<Product> = repository.getProductId(id)
}