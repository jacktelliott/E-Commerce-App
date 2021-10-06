package com.jackelliott.ecommerceapp.database.product.core

import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.impl.ProductCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideProductCacheDataSource(): ProductCacheDataSource {
        return ProductCacheDataSourceImpl()
    }

}