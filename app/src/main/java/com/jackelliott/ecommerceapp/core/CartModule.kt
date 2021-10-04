package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.ProductScope
import com.jackelliott.ecommerceapp.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.database.product.cart.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import dagger.Module
import dagger.Provides

@Module
class CartModule {

    @ProductScope
    @Provides
    fun provideCartViewModelFactory(
        addProductUseCase: AddProductUseCase,
        removeProductUseCase: RemoveProductUseCase
    ): CartViewModelFactory {
        return CartViewModelFactory(
            addProductUseCase,
            removeProductUseCase
        )
    }

}