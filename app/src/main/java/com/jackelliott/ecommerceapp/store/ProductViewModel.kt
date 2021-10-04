package com.jackelliott.ecommerceapp.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductUseCase: GetProductUseCase,
    private val updateProductsUseCase: UpdateProductsUseCase
) : ViewModel() {

    fun getProduct() = liveData {
        viewModelScope.launch(Dispatchers.IO) {
            val productList = getProductUseCase.execute()
            emit(productList)
        }
    }

    fun updateProduct() = liveData {
        viewModelScope.launch(Dispatchers.IO) {
            val productList = updateProductsUseCase.execute()
            emit(productList)
        }
    }
}