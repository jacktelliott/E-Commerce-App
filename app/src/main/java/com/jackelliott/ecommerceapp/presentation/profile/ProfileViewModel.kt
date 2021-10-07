package com.jackelliott.ecommerceapp.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jackelliott.ecommerceapp.database.profile.*
import com.jackelliott.ecommerceapp.database.profile.repository.AddSubscriberUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.LoginUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.RemoveSubscriberUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.UpdateSubscriberUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val addSubscriberUseCase: AddSubscriberUseCase,
    private val removeSubscriberUseCase: RemoveSubscriberUseCase,
    private val updateSubscriberUseCase: UpdateSubscriberUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val subscriberResults: MutableLiveData<List<Subscriber>> = MutableLiveData()

    fun addSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            addSubscriberUseCase.execute(subscriber)
        }
    }

    fun removeSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            removeSubscriberUseCase.execute(subscriber)
        }
    }

    fun updateSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            updateSubscriberUseCase.execute(subscriber)
        }
    }

    fun login(email: String, password: String) : Boolean  {
        var loggedIn = false
        viewModelScope.launch(Dispatchers.IO) {
            loggedIn = loginUseCase.execute(email, password)
        }
        return loggedIn
    }
}