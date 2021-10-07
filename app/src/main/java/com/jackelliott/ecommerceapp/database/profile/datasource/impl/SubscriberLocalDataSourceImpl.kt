package com.jackelliott.ecommerceapp.database.profile.datasource.impl

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.SubscriberDAO
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubscriberLocalDataSourceImpl @Inject constructor(private val subscriberDAO: SubscriberDAO) :
    SubscriberLocalDataSource {
    override suspend fun getSubscribersFromDB(): List<Subscriber> {
        return subscriberDAO.getAllSubscribers()
    }

    override suspend fun addSubscriberToDB(subscriber: Subscriber) {
        CoroutineScope(Dispatchers.IO).launch {
            subscriberDAO.insertSubscriber(subscriber)
        }
    }

    override suspend fun removeSubscriberFromDB(subscriber: Subscriber) {
        CoroutineScope(Dispatchers.IO).launch {
            subscriberDAO.deleteSubscriber(subscriber)
        }
    }

    override suspend fun updateSubscriber(subscriber: Subscriber) {
        CoroutineScope(Dispatchers.IO).launch {
            subscriberDAO.updateSubscriber(subscriber)
        }
    }
}