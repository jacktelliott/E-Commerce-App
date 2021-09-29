package com.jackelliott.ecommerceapp.database.product

class UpdateProductsUseCase (private val productRepository: ProductRepository) {
    suspend fun execute(): List<Product>? = productRepository.updateProducts()
}