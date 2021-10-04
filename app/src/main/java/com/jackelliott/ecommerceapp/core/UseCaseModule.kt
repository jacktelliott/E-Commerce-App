package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.product.store.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.CartRepository
import com.jackelliott.ecommerceapp.database.product.cart.GetProductsInCartUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.ProductRepository
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
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

    @Provides
    fun provideAddProductUseCase(productRepository: ProductRepository): AddProductUseCase {
        return AddProductUseCase(productRepository)
    }

    @Provides
    fun provideRemoveProductUseCase(cartRepository: CartRepository): RemoveProductUseCase {
        return RemoveProductUseCase(cartRepository)
    }

    @Provides
    fun provideGetProductsInCartUseCase(cartRepository: CartRepository): GetProductsInCartUseCase {
        return GetProductsInCartUseCase(cartRepository)
    }
}