package com.jackelliott.ecommerceapp.database.profile.repository

import javax.inject.Inject

class LoginUseCase @Inject constructor(private val subscriberRepository: SubscriberRepository) {
    suspend fun execute(email: String, password: String) =
        subscriberRepository.login(email, password)
}