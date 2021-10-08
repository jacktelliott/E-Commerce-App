package com.jackelliott.ecommerceapp.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.PrimaryKey
import com.jackelliott.ecommerceapp.database.profile.*
import com.jackelliott.ecommerceapp.database.profile.repository.usecases.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val addSubscriberUseCase: AddSubscriberUseCase,
    private val removeSubscriberUseCase: RemoveSubscriberUseCase,
    private val updateSubscriberUseCase: UpdateSubscriberUseCase,
    private val loginUseCase: LoginUseCase,
    private val getLoggedInSubscriberUseCase: GetLoggedInSubscriberUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val loggedInUseCase: LoggedInUseCase
) : ViewModel() {

    private val subscriberResults: MutableLiveData<Subscriber> = MutableLiveData()
    private val loginResult: MutableLiveData<Boolean> = MutableLiveData()
    private val loggedInResult: MutableLiveData<Boolean> = MutableLiveData()

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

    fun login(email: String, password: String) : MutableLiveData<Boolean>  {
        viewModelScope.launch(Dispatchers.IO) {
            val login = loginUseCase.execute(email, password)
            loginResult.postValue(login)
        }
        return loginResult
    }

    fun getLoggedInSubscriber(email: String, password: String): MutableLiveData<Subscriber> {
        viewModelScope.launch(Dispatchers.IO) {
            val subscriber = getLoggedInSubscriberUseCase.execute(email, password)
            subscriberResults.postValue(subscriber)
        }
        return subscriberResults
    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            logoutUseCase.execute()
        }
    }

    fun loggedIn(): MutableLiveData<Boolean> {
        viewModelScope.launch(Dispatchers.IO) {
            val loggedIn = loggedInUseCase.execute()
            loggedInResult.postValue(loggedIn)
        }
        return loggedInResult
    }
}