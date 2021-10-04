package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.cart.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import com.jackelliott.ecommerceapp.store.ProductViewModelFactory
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
        updateProductsUseCase: UpdateProductsUseCase
    ): ProductViewModelFactory {
        return ProductViewModelFactory(getProductUseCase, updateProductsUseCase)
    }

    @Singleton
    @Provides
    fun providesCartViewModelFactory(
        addProductUseCase: AddProductUseCase,
        removeProductUseCase: RemoveProductUseCase
    ): CartViewModelFactory {
        return CartViewModelFactory(addProductUseCase, removeProductUseCase)
    }
}