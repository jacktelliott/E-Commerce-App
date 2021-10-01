package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.product.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.ProductRepository
import com.jackelliott.ecommerceapp.database.product.UpdateProductsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetProductUseCase(productRepository: ProductRepository): GetProductUseCase {
        return GetProductUseCase(productRepository)
    }

    @Provides
    fun providesUpdateProductUseCase(productRepository: ProductRepository): UpdateProductsUseCase {
        return UpdateProductsUseCase(productRepository)
    }
}