package com.tzuzulcode.chat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeViewModel:ViewModel() {
    private var auth: FirebaseAuth = Firebase.auth
    private val _isLoggedIn = MutableLiveData<Boolean>(true)
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn


    fun logout(){
        auth.signOut()
        _isLoggedIn.value = false
    }
}