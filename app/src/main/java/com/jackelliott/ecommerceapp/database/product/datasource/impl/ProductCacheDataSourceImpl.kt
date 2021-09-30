package com.jackelliott.ecommerceapp.database.product.datasource.impl

import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource

class ProductCacheDataSourceImpl : ProductCacheDataSource {

    private var productList = ArrayList<Product>()

    override suspend fun getProductsFromCache(): List<Product> {
        return productList
    }

    override suspend fun saveProductsToCache(products: List<Product>) {
        productList.clear()
        productList = ArrayList(products)
    }
}