package com.jackelliott.ecommerceapp.database.profile.datasource.impl

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberCacheDataSource

class SubscriberCacheDataSourceImpl : SubscriberCacheDataSource {

    private lateinit var subscriber: Subscriber

    override suspend fun saveSubscribersToCache(subscriber: Subscriber) {
        this.subscriber = subscriber
    }

    override suspend fun getSubscriber(): Subscriber {
        return subscriber
    }
}