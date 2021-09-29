package com.example.login.ui.main

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LogInViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _firstname = MutableLiveData<String>()
    val firstname: LiveData<String>
        get() = _firstname

    private val _firstnameFilled = MutableLiveData<Boolean>()
    val firstnameFilled : LiveData<Boolean>
        get() = _firstnameFilled

    private val _lastnameFilled = MutableLiveData<Boolean>()
    val lastnameFilled : LiveData<Boolean>
        get() = _lastnameFilled

    private val _usernameFilled = MutableLiveData<Boolean>()
    val usernameFilled : LiveData<Boolean>
        get() = _usernameFilled

    private val _lastname = MutableLiveData<String>()
    val lastname: LiveData<String>
        get() = _lastname

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _eventLogInFinish = MutableLiveData<Boolean>()
    val eventLogInFinish : LiveData<Boolean>
        get() = _eventLogInFinish


    init {
        _firstname.value = ""
        _lastname.value = ""
        _username.value = ""
        _eventLogInFinish.value = false
        _firstnameFilled.value = false
        _lastnameFilled.value = false
        _usernameFilled.value = false
    }

    fun canWePass(){
        if(_firstnameFilled.value == true && _lastnameFilled.value == true && _usernameFilled.value == true)
        {
            _eventLogInFinish.value = true
        }
    }

    fun onCanWePassComplete(){
        _eventLogInFinish.value = false
    }

    fun updateFirstName(name: String)
    {
        if(name.length > 0)
        {
            _firstname.value = name
            _firstnameFilled.value = true
        }
        else
        {
            _firstnameFilled.value = false
        }
        canWePass()
    }

    fun updateLastName(name: String)
    {
        if(name.length > 0)
        {
            _lastname.value = name
            _lastnameFilled.value = true
        }
        else
        {
            _lastnameFilled.value = false
        }
        canWePass()
    }

    fun updateUserName(name: String)
    {
        if(name.length > 0)
        {
            _username.value = name
            _usernameFilled.value = true
        }
        else
        {
            _usernameFilled.value = false
        }
        canWePass()
    }

}