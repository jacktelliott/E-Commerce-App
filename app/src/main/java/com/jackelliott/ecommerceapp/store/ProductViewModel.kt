package com.jackelliott.ecommerceapp.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.store.GetProductUseCase
import com.jackelliott.ecommerceapp.database.product.store.UpdateProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductUseCase: GetProductUseCase,
    private val updateProductsUseCase: UpdateProductsUseCase
) : ViewModel() {
    private val productsResults: MutableLiveData<List<Product>> = MutableLiveData()

    fun getProduct(): MutableLiveData<List<Product>> {
        viewModelScope.launch(Dispatchers.IO) {
            val productList = getProductUseCase.execute()
            productsResults.postValue(productList!!)
        }
        return productsResults
    }

    fun updateProduct() = liveData {
        viewModelScope.launch(Dispatchers.IO) {
            val productList = updateProductsUseCase.execute()
            emit(productList)
        }
    }
}