package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.product.datasource.ProductCacheDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.impl.ProductCacheDataSourceImpl
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberCacheDataSource
import com.jackelliott.ecommerceapp.database.profile.datasource.impl.SubscriberCacheDataSourceImpl
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

    @Singleton
    @Provides
    fun provideSubscriberCacheDataSource(): SubscriberCacheDataSource {
        return SubscriberCacheDataSourceImpl()
    }
}