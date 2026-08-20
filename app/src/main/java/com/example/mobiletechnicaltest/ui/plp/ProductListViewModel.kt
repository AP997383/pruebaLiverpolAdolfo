package com.example.mobiletechnicaltest.ui.plp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiletechnicaltest.data.remote.ApiClient
import com.example.mobiletechnicaltest.domain.model.Product
import com.example.mobiletechnicaltest.repository.ProductRepository
import com.example.mobiletechnicaltest.ui.pdp.useCase.ProductDetailUseCase
import com.example.mobiletechnicaltest.ui.plp.usecase.ProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel  @Inject constructor(
        private val useCase: ProductListUseCase,
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(arrayListOf())
    val products = _products.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getProducts() = viewModelScope.launch {
        _isLoading.value =true
         useCase.getAllProducts().collect {
             _isLoading.value=false
             _products.value = it
         }
    }
}
