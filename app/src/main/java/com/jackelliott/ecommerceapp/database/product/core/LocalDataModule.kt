package com.jackelliott.ecommerceapp.database.product.core

import com.jackelliott.ecommerceapp.database.product.ProductDAO
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.impl.ProductLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideProductLocalDataSource(productDAO: ProductDAO): ProductLocalDataSource {
        return ProductLocalDataSourceImpl(productDAO)
    }

}