package com.jackelliott.ecommerceapp.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
import javax.inject.Inject

class ProductViewModelFactory @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    private val updateProductsUseCase: UpdateProductsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(getProductUseCase, updateProductsUseCase) as T
    }
}