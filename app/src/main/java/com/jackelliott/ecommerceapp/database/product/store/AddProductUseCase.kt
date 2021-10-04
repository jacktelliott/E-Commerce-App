package com.jackelliott.ecommerceapp.database.product.store

import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.store.ProductRepository
import javax.inject.Inject

class AddProductUseCase @Inject constructor(private val productRepository: ProductRepository){
    suspend fun execute(product: Product): List<Product>? = productRepository.addProduct(product)
}