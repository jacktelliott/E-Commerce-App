package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.presentation.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.database.product.store.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.GetProductsInCartUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import com.jackelliott.ecommerceapp.presentation.store.ProductViewModelFactory
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FactoryModule {

    @Singleton
    @Provides
    fun providesProductViewModelFactory(
        getProductUseCase: GetProductUseCase,
        updateProductsUseCase: UpdateProductsUseCase,
        addProductUseCase: AddProductUseCase
    ): ProductViewModelFactory {
        return ProductViewModelFactory(getProductUseCase, updateProductsUseCase, addProductUseCase)
    }

    @Singleton
    @Provides
    fun providesCartViewModelFactory(
        removeProductUseCase: RemoveProductUseCase,
        getProductsInCartUseCase: GetProductsInCartUseCase
    ): CartViewModelFactory {
        return CartViewModelFactory(removeProductUseCase, getProductsInCartUseCase)
    }
}