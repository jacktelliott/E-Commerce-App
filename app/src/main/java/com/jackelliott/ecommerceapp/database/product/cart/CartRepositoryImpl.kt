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

    override suspend fun removeProduct(product: Product): List<Product> {
        try {
            productLocalDataSource.removeProduct(product)
        } catch (exception: Exception) {
            Log.i("removeProduct", exception.message.toString())
        }
        return returnList(product)
    }

    override suspend fun getProductsInCart(): MutableList<Product>? {
        var allProducts: List<Product> = getProductsFromCache()
        var productsInCart: MutableList<Product> = mutableListOf()
        for (product in allProducts) {
            if (product.quantity > 0) {
                productsInCart.add(product)
            }
        }
        return productsInCart
    }

    fun returnList(product: Product): List<Product> = listOf(product)

    suspend fun getProductsFromCache(): List<Product> {
        var productList: List<Product> = arrayListOf()
        try {
            productList = getProductsFromDB()//productCacheDataSource.getProductsFromCache()
            if (productList.isNotEmpty()) {
                return productList
            }
        } catch (exception: Exception) {
            Log.i("getProductsFromCache", exception.message.toString())
        }
        return productList
    }

    suspend fun getProductsFromDB(): List<Product> {
        var productList: List<Product> = arrayListOf()
        try {
            productList = productLocalDataSource.getProductsFromDB()
            if (productList.isNotEmpty()) {
                return productList
            }
        } catch (exception: Exception) {
            Log.i("getProductsFromDB", exception.message.toString())
        }
        return productList
    }
}