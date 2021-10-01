package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.store.ProductViewModelFactory
import com.jackelliott.ecommerceapp.database.product.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.UpdateProductsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FactoryModule {

    @Singleton
    @Provides
    fun providesViewModelFactory(
        getProductUseCase: GetProductUseCase,
        updateProductsUseCase: UpdateProductsUseCase
    ): ProductViewModelFactory {
        return ProductViewModelFactory(getProductUseCase, updateProductsUseCase)
    }
}