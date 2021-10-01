package com.jackelliott.ecommerceapp.database.product

import javax.inject.Inject

class UpdateProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(): List<Product>? = productRepository.updateProducts()
}