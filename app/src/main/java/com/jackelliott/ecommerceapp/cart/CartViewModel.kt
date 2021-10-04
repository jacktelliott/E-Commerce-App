package com.jackelliott.ecommerceapp.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.cart.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase

class CartViewModel (
    private val addProductUseCase: AddProductUseCase,
    private val removeProductUseCase: RemoveProductUseCase
        ) : ViewModel() {

    suspend fun addProduct(product: Product) = liveData {
        val productList = addProductUseCase.execute(product)
        emit(productList)
    }

    suspend fun removeProduct(product: Product) = liveData {
        val productList = removeProductUseCase.execute(product)
        emit(productList)
    }
}