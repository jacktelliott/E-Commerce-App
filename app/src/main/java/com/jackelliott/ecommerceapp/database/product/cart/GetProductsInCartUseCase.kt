package com.jackelliott.ecommerceapp.database.product.cart

import javax.inject.Inject

class GetProductsInCartUseCase @Inject constructor(private val cartRepository: CartRepository){
    suspend fun execute() = cartRepository.getProductsInCart()
}