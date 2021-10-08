package com.jackelliott.ecommerceapp.database.profile.datasource.impl

import android.util.Log
import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberCacheDataSource

class SubscriberCacheDataSourceImpl : SubscriberCacheDataSource {

    private lateinit var subscriber: Subscriber
    private var isLoggedIn = false

    override suspend fun saveSubscribersToCache(subscriber: Subscriber) {
        this.subscriber = subscriber
    }

    override suspend fun getSubscriber(): Subscriber {
        return subscriber
    }

    override suspend fun getLoggedIn(): Boolean {
        return this.isLoggedIn
    }

    override suspend fun setLoggedIn(isLoggedIn: Boolean) {
        this.isLoggedIn = isLoggedIn
    }
}