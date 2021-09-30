package com.jackelliott.ecommerceapp.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.profile.SubscriberRepository
import java.lang.IllegalArgumentException

class ProfileViewModelFactory(private val repository: SubscriberRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}