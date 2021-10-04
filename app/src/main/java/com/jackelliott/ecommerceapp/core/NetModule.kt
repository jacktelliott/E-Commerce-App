package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.database.FsApiService
import com.jackelliott.ecommerceapp.database.RetrofitInstance
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
//        var logging = HttpLoggingInterceptor()//
//        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)//
//        var client = OkHttpClient.Builder()//
//            .addInterceptor(logging)//
//            .build()//
        return Retrofit.Builder()
//            .baseUrl("https://api.domain.com")//
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RetrofitInstance.BASE_URL)
//            .client(client)//
            .build()
    }

    @Singleton
    @Provides
    fun provideFsApiService(retrofit: Retrofit): FsApiService {
        return retrofit.create(FsApiService::class.java)
    }

}