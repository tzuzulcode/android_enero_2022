package com.tzuzulcode.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthViewModel:ViewModel() {
    private var auth:FirebaseAuth = Firebase.auth
    var currentUser = auth.currentUser
    var isLoggedIn = false
    var message = ""
    var isError = false

    init{
        if (currentUser!=null){
            isLoggedIn = true
        }
    }


    fun login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{ result ->
                if(result.isSuccessful){
                    isLoggedIn = true
                    println(result.result.user)
                    Log.d("AUTH","Usuario registrado: "+currentUser.toString())
                }else{
                    Log.d("AUTH","Usuario fallido registrado: ",result.exception)
                    message = "El inicio de sesión falló"
                    isError = true
                }
            }
    }

    fun register(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { result ->
                if(result.isSuccessful){
                    isLoggedIn = true
                    println(result.result.user)
                    Log.d("AUTH","Usuario registrado: "+currentUser.toString())
                }else{
                    Log.d("AUTH","Usuario fallido registrado: ",result.exception)
                    message = "El inicio de sesión falló"
                    isError = true
                }
            }
    }
}