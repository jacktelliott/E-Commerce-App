package com.jackelliott.ecommerceapp.presentation.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.store.AddProductUseCase
import com.jackelliott.ecommerceapp.database.product.cart.GetProductsInCartUseCase
import com.jackelliott.ecommerceapp.database.product.cart.RemoveProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val removeProductUseCase: RemoveProductUseCase,
    private val getProductsInCartUseCase: GetProductsInCartUseCase
) : ViewModel() {

    private val productsResults: MutableLiveData<List<Product>> = MutableLiveData()

    fun removeProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            removeProductUseCase.execute(product)
        }
    }

    fun getProductsInCart(): MutableLiveData<List<Product>> {
        viewModelScope.launch(Dispatchers.IO) {
            val productList = getProductsInCartUseCase.execute()
            productsResults.postValue(productList!!)
        }
        return productsResults
    }
}