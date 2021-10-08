package com.jackelliott.ecommerceapp.database.profile.repository

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.SubscriberDAO

interface SubscriberRepository {

    suspend fun addSubscriber(subscriber: Subscriber)
    suspend fun updateSubscriber(subscriber: Subscriber)
    suspend fun removeSubscriber(subscriber: Subscriber)
    suspend fun login(email: String, password: String) : Boolean
    suspend fun getLoggedInSubscriber(email: String, password: String): Subscriber
    suspend fun logout()
    suspend fun loggedIn(): Boolean
}