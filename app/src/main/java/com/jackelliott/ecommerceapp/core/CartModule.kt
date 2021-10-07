package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.presentation.ProductScope
import com.jackelliott.ecommerceapp.presentation.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.database.product.cart.GetProductsInCartUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import dagger.Module
import dagger.Provides

@Module
class CartModule {

    @ProductScope
    @Provides
    fun provideCartViewModelFactory(
        removeProductUseCase: RemoveProductUseCase,
        getProductsInCartUseCase: GetProductsInCartUseCase
    ): CartViewModelFactory {
        return CartViewModelFactory(
            removeProductUseCase,
            getProductsInCartUseCase
        )
    }

}