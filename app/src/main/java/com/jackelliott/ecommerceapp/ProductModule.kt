package com.jackelliott.ecommerceapp

import com.jackelliott.ecommerceapp.store.ProductViewModelFactory
import com.jackelliott.ecommerceapp.database.product.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.UpdateProductsUseCase
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