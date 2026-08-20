package com.example.mobiletechnicaltest.repository

import com.example.mobiletechnicaltest.data.remote.FakeStoreApi
import com.example.mobiletechnicaltest.domain.model.Product
import com.example.mobiletechnicaltest.domain.model.toProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Exposes product data to the ViewModels.
 *
 * // TODO Candidate: call [api], map the response DTOs into [Product],
 * // TODO Candidate: and handle network/parsing errors as you see fit.
 */
class ProductRepository @Inject constructor(
    private val api: FakeStoreApi

    ) {
    fun getProducts(): Flow<List<Product>> = flow {
        val response = api.getProducts()
        if (response.isSuccessful) {
            val body = response.body()
            emit(body?.map { it.toProduct() } ?: emptyList())
        } else {
            emit(emptyList())
        }
    }

     fun getProductId(id: Int):Flow<Product> = flow {
        val response = api.getProduct(id)
        if (response.isSuccessful) {
            val body = response.body()
            emit(body?.toProduct()?: Product())
        } else {
            emit(Product())
        }
    }

}
