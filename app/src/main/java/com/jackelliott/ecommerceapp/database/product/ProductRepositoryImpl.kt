package com.jackelliott.ecommerceapp.database.product

import android.util.Log
import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import java.lang.Exception

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
    private val productCacheDataSource: ProductCacheDataSource
) : ProductRepository {

    override suspend fun getProducts(): List<Product>? {
        return getProductsFromCache()
    }

    override suspend fun updateProducts(): List<Product>? {
        val newListOfProduct = getProductsFromAPI()
        productLocalDataSource.clearAll()
        productLocalDataSource.saveProductsToDB(newListOfProduct)
        productCacheDataSource.saveProductsToCache(newListOfProduct)
        return newListOfProduct
    }


    suspend fun getProductsFromAPI(): List<Product> {
        lateinit var productList: List<Product>
        try {
            val response = productRemoteDataSource.getProducts()
            val body = response.body()
            if (body != null) {
//                productList = body.products
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (productList.size > 0) {
            return productList
        } else {
            productList = getProductsFromDB()
            productLocalDataSource.saveProductsToDB(productList)
        }
        return productList
    }

    suspend fun getProductsFromCache(): List<Product> {
        lateinit var productList: List<Product>
        try {
            productList = productCacheDataSource.getProductsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (productList.size > 0) {
            return productList
        } else {
            productList = getProductsFromDB()
            productCacheDataSource.saveProductsToCache(productList)
        }
        return productList
    }

    suspend fun getProductsFromDB(): List<Product> {
        lateinit var productList: List<Product>
        try {
            productList = productLocalDataSource.getProductsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (productList.size > 0) {
            return productList
        } else {
            productList = getProductsFromDB()
            productLocalDataSource.saveProductsToDB(productList)
        }
        return productList
    }
}