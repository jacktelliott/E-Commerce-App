package com.jackelliott.ecommerceapp.database.product

class GetProductUseCase (private val productRepository: ProductRepository) {
    suspend fun execute(): List<Product>? = productRepository.getProducts()
}