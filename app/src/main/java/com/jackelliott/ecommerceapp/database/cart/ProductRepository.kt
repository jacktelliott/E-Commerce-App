package com.jackelliott.ecommerceapp.database.cart

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.SubscriberDAO

class ProductRepository (private val dao: ProductDAO) {

    val subscribers = dao.getAllProducts()

    suspend fun add(product: Product) {
        dao.addProduct(product)
    }

    suspend fun remove(product: Product) {
        dao.removeProduct(product)
    }

}