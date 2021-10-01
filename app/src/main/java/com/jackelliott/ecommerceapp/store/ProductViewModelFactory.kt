package com.jackelliott.ecommerceapp.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.product.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.UpdateProductsUseCase

class ProductViewModelFactory(
    private val getProductUseCase: GetProductUseCase,
    private val updateProductsUseCase: UpdateProductsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(getProductUseCase, updateProductsUseCase) as T
    }
}