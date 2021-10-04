package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.ProductScope
import com.jackelliott.ecommerceapp.store.ProductViewModelFactory
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
import dagger.Module
import dagger.Provides

@Module
class ProductModule {

    @ProductScope
    @Provides
    fun provideProductViewModelFactory(
        getProductUseCase: GetProductUseCase,
        updateProductsUseCase: UpdateProductsUseCase
    ): ProductViewModelFactory {
        return ProductViewModelFactory(
            getProductUseCase,
            updateProductsUseCase
        )
    }

}