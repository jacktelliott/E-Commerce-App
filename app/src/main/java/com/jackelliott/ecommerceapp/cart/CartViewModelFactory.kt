package com.jackelliott.ecommerceapp.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.product.cart.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import javax.inject.Inject

class CartViewModelFactory @Inject constructor(
    private val addProductUseCase: AddProductUseCase,
    private val removeProductUseCase: RemoveProductUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(addProductUseCase, removeProductUseCase) as T
    }
}