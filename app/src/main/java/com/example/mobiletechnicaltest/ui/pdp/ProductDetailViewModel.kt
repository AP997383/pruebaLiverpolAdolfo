package com.example.mobiletechnicaltest.ui.pdp

import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mobiletechnicaltest.data.remote.ApiClient
import com.example.mobiletechnicaltest.domain.model.Product
import com.example.mobiletechnicaltest.repository.ProductRepository

class ProductDetailViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val productoDetalle by remember {  mutableSetOf(Product()) }
    private val repository = ProductRepository(ApiClient.api)




    fun getSingleProduct(idProduct: String){
        repository.getProduct(idProduct)
    }



    // TODO Candidate:
    // - Read the "productId" navigation argument from savedStateHandle
    // - Fetch the product detail from the repository (viewModelScope + coroutines)
    // - Handle Loading / Success / Error
    // - Expose the resulting state to ProductDetailFragment (e.g. StateFlow)

    init {
        // TODO Candidate: trigger the initial product load
    }
}
