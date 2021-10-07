package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.presentation.ProductScope
import com.jackelliott.ecommerceapp.database.product.store.AddProductUseCase
import com.jackelliott.ecommerceapp.presentation.store.ProductViewModelFactory
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
        updateProductsUseCase: UpdateProductsUseCase,
        addProductUseCase: AddProductUseCase
    ): ProductViewModelFactory {
        return ProductViewModelFactory(
            getProductUseCase,
            updateProductsUseCase,
            addProductUseCase
        )
    }

}