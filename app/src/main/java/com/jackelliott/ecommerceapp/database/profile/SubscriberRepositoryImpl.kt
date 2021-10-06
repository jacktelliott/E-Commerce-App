package com.jackelliott.ecommerceapp.database.profile

import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberCacheDataSource
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberLocalDataSource
import javax.inject.Inject

class SubscriberRepositoryImpl @Inject constructor(
    subscriberLocalDataSource: SubscriberLocalDataSource,
    subscriberCacheDataSource: SubscriberCacheDataSource
) : SubscriberRepository {

    override suspend fun addSubscriber(subscriber: Subscriber) {

    }

    override suspend fun updateSubscriber(subscriber: Subscriber) {

    }

    override suspend fun removeSubscriber(subscriber: Subscriber) {

    }
}