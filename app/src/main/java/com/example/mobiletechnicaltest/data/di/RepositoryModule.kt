package com.example.mobiletechnicaltest.data.di
import com.example.mobiletechnicaltest.repository.ProductRepository
import com.example.mobiletechnicaltest.ui.pdp.useCase.ProductDetailUseCase
import com.example.mobiletechnicaltest.ui.plp.usecase.ProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideProductsUsesCase(
        repository: ProductRepository
    ): ProductListUseCase = ProductListUseCase(repository)
    @Provides
    fun provideOnlyOneProductUseCase(
        repository: ProductRepository
    ): ProductDetailUseCase = ProductDetailUseCase(repository)
}