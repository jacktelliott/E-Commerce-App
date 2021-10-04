package com.jackelliott.ecommerceapp.database.product.store

import android.util.Log
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import java.lang.Exception
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource,
    private val productCacheDataSource: ProductCacheDataSource
) : ProductRepository {

    override suspend fun getProducts(): List<Product>? {
        return getProductsFromCache()
    }

    //Takes products from the Remote Data Source (the url) and saves them to the DB and the Cache
    //In this case, the RDS will not be updating, so it is not necessary to call this more than once
    override suspend fun updateProducts(): List<Product>? {
        val newListOfProduct = getProductsFromAPI()
        productLocalDataSource.clearAll()
        productLocalDataSource.saveProductsToDB(newListOfProduct)
        productCacheDataSource.saveProductsToCache(newListOfProduct)
        return newListOfProduct
    }

    override suspend fun addProduct(product: Product): List<Product> {
        try {
            productLocalDataSource.addProduct(product)
        } catch (exception: Exception) {
            Log.i("addProduct", exception.message.toString())
        }
        return returnList(product)
    }

    fun returnList(product: Product): List<Product> = listOf(product)

    suspend fun getProductsFromAPI(): List<Product> {
        var productList: List<Product> = arrayListOf()
        try {
            val response = productRemoteDataSource.getProducts()
            val body = response.body()
            if (body != null) {
                productList = body
            }
            if (productList.isNotEmpty()) {
                return productList
            } else {
                productList = getProductsFromDB()
                productLocalDataSource.saveProductsToDB(productList)
            }
        } catch (exception: Exception) {
            Log.i("getProductsFromAPI", exception.message.toString())
        }
        return productList
    }

    suspend fun getProductsFromCache(): List<Product> {
        var productList: List<Product> = arrayListOf()
        try {
            productList = getProductsFromDB()//productCacheDataSource.getProductsFromCache()
            if (productList.isNotEmpty()) {
                return productList
            } else {
                productList = getProductsFromAPI()
                productCacheDataSource.saveProductsToCache(productList)
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
            } else {
                productList = getProductsFromAPI()
                productLocalDataSource.saveProductsToDB(productList)
            }
        } catch (exception: Exception) {
            Log.i("getProductsFromDB", exception.message.toString())
        }
        return productList
    }
}