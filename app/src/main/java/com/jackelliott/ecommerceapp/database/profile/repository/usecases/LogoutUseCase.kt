package com.jackelliott.ecommerceapp.database.profile.repository.usecases

import com.jackelliott.ecommerceapp.database.profile.repository.SubscriberRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val subscriberRepository: SubscriberRepository) {
    suspend fun execute() =
        subscriberRepository.logout()
}