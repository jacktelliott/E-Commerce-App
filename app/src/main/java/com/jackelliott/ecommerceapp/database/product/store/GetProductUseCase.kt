package com.jackelliott.ecommerceapp.database.product.store

import com.jackelliott.ecommerceapp.database.product.Product
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(): List<Product>? = productRepository.getProducts()
}