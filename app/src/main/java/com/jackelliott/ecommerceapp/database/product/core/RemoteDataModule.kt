package com.jackelliott.ecommerceapp.database.product.core

import com.jackelliott.ecommerceapp.database.product.api.FsApiService
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import com.jackelliott.ecommerceapp.database.product.datasource.impl.ProductRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideProductRemoteDataSource(fsApiService: FsApiService): ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(fsApiService)
    }

}