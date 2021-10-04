package com.jackelliott.ecommerceapp.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase

class ProductViewModel(
    private val getProductUseCase: GetProductUseCase,
    private val updateProductsUseCase: UpdateProductsUseCase
) : ViewModel() {

    fun getProduct() = liveData {
        val productList = getProductUseCase.execute()
        emit(productList)
    }

    fun updateProduct() = liveData {
        val productList = updateProductsUseCase.execute()
        emit(productList)
    }
}