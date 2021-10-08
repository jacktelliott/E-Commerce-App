package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.product.ProductDAO
import com.jackelliott.ecommerceapp.database.product.datasource.ProductLocalDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.impl.ProductLocalDataSourceImpl
import com.jackelliott.ecommerceapp.database.profile.SubscriberDAO
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberLocalDataSource
import com.jackelliott.ecommerceapp.database.profile.datasource.impl.SubscriberLocalDataSourceImpl
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

    @Singleton
    @Provides
    fun provideSubscriberLocalDataSource(subscriberDAO: SubscriberDAO): SubscriberLocalDataSource {
        return SubscriberLocalDataSourceImpl(subscriberDAO)
    }
}