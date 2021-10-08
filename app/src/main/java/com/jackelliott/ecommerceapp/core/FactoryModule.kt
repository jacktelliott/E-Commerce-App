package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.presentation.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.database.product.store.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.GetProductsInCartUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import com.jackelliott.ecommerceapp.presentation.store.ProductViewModelFactory
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.usecases.*
import com.jackelliott.ecommerceapp.presentation.profile.ProfileViewModelFactory
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

    @Singleton
    @Provides
    fun providesProfileViewModelFactory(
        addSubscriberUseCase: AddSubscriberUseCase,
        removeSubscriberUseCase: RemoveSubscriberUseCase,
        updateSubscriberUseCase: UpdateSubscriberUseCase,
        loginUseCase: LoginUseCase,
        getLoggedInSubscriberUseCase: GetLoggedInSubscriberUseCase,
        logoutUseCase: LogoutUseCase,
        loggedInUseCase: LoggedInUseCase
    ) : ProfileViewModelFactory {
        return ProfileViewModelFactory(
            addSubscriberUseCase,
            removeSubscriberUseCase,
            updateSubscriberUseCase,
            loginUseCase,
            getLoggedInSubscriberUseCase,
            logoutUseCase,
            loggedInUseCase
        )
    }
}