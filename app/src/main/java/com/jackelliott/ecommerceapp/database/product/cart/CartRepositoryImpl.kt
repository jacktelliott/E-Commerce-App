package com.jackelliott.ecommerceapp.database.product.cart

import android.util.Log
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import com.jackelliott.ecommerceapp.database.product.store.ProductRepository
import java.lang.Exception
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val productLocalDataSource: ProductLocalDataSource
) : CartRepository {
    override suspend fun addProduct(product: Product): List<Product> {
        try {
            productLocalDataSource.addProduct(product)
        } catch (exception: Exception) {
            Log.i("addProduct", exception.message.toString())
        }
        return returnList(product)
    }

    override suspend fun removeProduct(product: Product): List<Product> {
        try {
            productLocalDataSource.removeProduct(product)
        } catch (exception: Exception) {
            Log.i("removeProduct", exception.message.toString())
        }
        return returnList(product)
    }

    suspend fun returnList(product: Product): List<Product> = listOf(product)

}