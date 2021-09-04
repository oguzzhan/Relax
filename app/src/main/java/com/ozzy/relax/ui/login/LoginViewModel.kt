package com.ozzy.relax.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozzy.relax.utils.Event
import com.ozzy.relax.utils.Session


class LoginViewModel : ViewModel() {
    val userName = MutableLiveData<String>().apply { value = "asdasd" }
    val password = MutableLiveData<String>().apply { value = "1Qaafa" }
    val errorVisible = MutableLiveData<Boolean>().apply { value = false }

    val goToDashboard = MutableLiveData<Event<Boolean>>().apply { value = Event(false) }


    fun buttonClick() {
        if (validatePassword() && validateUserName()) {
            Log.d("matches", "success")
            Session.setInstance(userName.value ?: "")
            errorVisible.value = false
            goToDashboard.value = Event(true)
        } else {
            errorVisible.value = true
            goToDashboard.value = Event(false)
        }
    }

    private fun validateUserName(): Boolean {
        return (userName.value.isNullOrEmpty() || userName.value?.length!! < 2).not()
    }

    private fun validatePassword(): Boolean {
        val regexString = "^(?=.*[A-Z])(?=.*\\d).{6,}$"
        val regex = Regex(regexString)
        return regex.containsMatchIn(password.value ?: "")
    }
}

/*
* Username is longer than two characters
* Password should consist minimum 6 characters with at least 1 uppercase character, 1 number
* */