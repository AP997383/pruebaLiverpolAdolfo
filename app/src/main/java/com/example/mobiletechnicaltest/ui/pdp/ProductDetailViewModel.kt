package com.example.mobiletechnicaltest.ui.pdp

import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiletechnicaltest.data.remote.ApiClient
import com.example.mobiletechnicaltest.domain.model.Product
import com.example.mobiletechnicaltest.repository.ProductRepository
import com.example.mobiletechnicaltest.ui.pdp.useCase.ProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val useCase: ProductDetailUseCase,
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _singleProduct = MutableStateFlow<Product>(Product())
    val singleProduct = _singleProduct.asStateFlow()

    fun getSingleProduct(idProduct: Int){
        viewModelScope.launch {
            useCase.getDetailProduct(idProduct).collect {
                _singleProduct.value = it
            }
        }
    }

}
