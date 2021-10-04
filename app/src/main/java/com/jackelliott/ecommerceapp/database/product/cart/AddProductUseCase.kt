package com.jackelliott.ecommerceapp.database.product.cart

import com.jackelliott.ecommerceapp.database.product.Product
import javax.inject.Inject

class AddProductUseCase @Inject constructor(private val cartRepository: CartRepository){
    suspend fun execute(product: Product) = cartRepository.addProduct(product)
}