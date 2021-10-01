package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.FsApiService
import com.jackelliott.ecommerceapp.database.RetrofitInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RetrofitInstance.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideFsApiService(retrofit: Retrofit): FsApiService {
        return retrofit.create(FsApiService::class.java)
    }

}