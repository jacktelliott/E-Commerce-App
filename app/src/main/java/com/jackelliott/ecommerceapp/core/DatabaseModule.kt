package com.jackelliott.ecommerceapp.core

import android.app.Application
import androidx.room.Room
import com.jackelliott.ecommerceapp.database.product.ProductDatabase
import com.jackelliott.ecommerceapp.database.product.ProductDAO
import com.jackelliott.ecommerceapp.database.profile.SubscriberDAO
import com.jackelliott.ecommerceapp.database.profile.SubscriberDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideProductDatabase() : ProductDatabase {
        return Room.databaseBuilder(application, ProductDatabase::class.java, "product_data_table")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideProductDao(productDatabase: ProductDatabase): ProductDAO {
        return productDatabase.productDao()
    }

    @Singleton
    @Provides
    fun provideSubscriberDatabase(): SubscriberDatabase {
        return Room.databaseBuilder(application, SubscriberDatabase::class.java, "subscriber_data_table")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideSubscriberDao(subscriberDatabase: SubscriberDatabase) : SubscriberDAO {
        return subscriberDatabase.subscriberDao()
    }
}