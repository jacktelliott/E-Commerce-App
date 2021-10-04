package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.product.cart.CartRepository
import com.jackelliott.ecommerceapp.database.product.cart.CartRepositoryImpl
import com.jackelliott.ecommerceapp.database.product.store.ProductRepository
import com.jackelliott.ecommerceapp.database.product.store.ProductRepositoryImpl
import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productRemoteDataSource: ProductRemoteDataSource,
        productLocalDataSource: ProductLocalDataSource,
        productCacheDataSource: ProductCacheDataSource
    ): ProductRepository {
        return ProductRepositoryImpl(
            productRemoteDataSource,
            productLocalDataSource,
            productCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideCartRepository(
        productLocalDataSource: ProductLocalDataSource
    ): CartRepository {
        return CartRepositoryImpl(
            productLocalDataSource
        )
    }

}