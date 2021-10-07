package com.jackelliott.ecommerceapp.database.profile.repository

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import javax.inject.Inject

class AddSubscriberUseCase @Inject constructor(private val subscriberRepository: SubscriberRepository) {
    suspend fun execute(subscriber: Subscriber) = subscriberRepository.addSubscriber(subscriber)
}