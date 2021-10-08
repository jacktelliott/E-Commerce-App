package com.jackelliott.ecommerceapp.database.profile.repository.usecases

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.repository.SubscriberRepository
import javax.inject.Inject

class AddSubscriberUseCase @Inject constructor(private val subscriberRepository: SubscriberRepository) {
    suspend fun execute(subscriber: Subscriber) = subscriberRepository.addSubscriber(subscriber)
}