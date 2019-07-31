package com.example.coroutines.Jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestModel : ViewModel() {

    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }

    val user: LiveData<User> = liveData {
        val data = getAsyncData()
        emit(data)
    }

    private suspend fun getAsyncData(): User {
        delay(3000)
        return User("test")
    }

}


data class User(val name: String)