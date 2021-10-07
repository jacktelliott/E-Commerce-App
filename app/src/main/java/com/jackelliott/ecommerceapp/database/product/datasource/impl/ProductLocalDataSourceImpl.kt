package com.jackelliott.ecommerceapp.database.product.datasource.impl

import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.ProductDAO
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(private val productDao: ProductDAO) :
    ProductLocalDataSource {
    override suspend fun getProductsFromDB(): List<Product> {
        return productDao.getAllProducts()
    }

    override suspend fun saveProductsToDB(products: List<Product>) {
        CoroutineScope(Dispatchers.IO).launch {
            productDao.saveProducts(products)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            productDao.deleteAllProducts()
        }
    }

    override suspend fun addProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            product.quantity.plus(1)
            productDao.addProduct(product)
        }
    }

    override suspend fun removeProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            product.quantity.minus(1)
            productDao.removeProduct(product)
        }
    }

}