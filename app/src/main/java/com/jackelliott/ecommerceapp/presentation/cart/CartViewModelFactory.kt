package com.jackelliott.ecommerceapp.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.product.store.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.GetProductsInCartUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import javax.inject.Inject

class CartViewModelFactory @Inject constructor(
    private val removeProductUseCase: RemoveProductUseCase,
    private val getProductsInCartUseCase: GetProductsInCartUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(removeProductUseCase, getProductsInCartUseCase) as T
    }
}