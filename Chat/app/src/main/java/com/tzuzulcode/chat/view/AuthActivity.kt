package com.tzuzulcode.chat.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.tzuzulcode.chat.viewmodel.AuthViewModel


class AuthActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = AuthViewModel()

        viewModel.isLoggedIn.observe(this, Observer {
            if(it){
                val intent = Intent(this,ChatsActivity::class.java)

                startActivity(intent)
            }
        })

        setContent {
            AuthActivityContent(){ email,password,isLogin ->
                viewModel.auth(email = email, password = password, isLogin = isLogin)
            }
        }
    }
}


@Composable
fun AuthActivityContent(auth:(email:String,password:String,isLogin:Boolean)->Unit){
    val email = remember{
        mutableStateOf("")
    }
    val password = remember{
        mutableStateOf("")
    }

    val isLogIn = remember {
        mutableStateOf(true)
    }

    Column {

        if(isLogIn.value){
            Text("Login")
        }else{
            Text("Register")
        }
        Switch(checked = isLogIn.value, onCheckedChange = {
            isLogIn.value = it
        })
        EmailField(value = email.value){ newValue ->
            email.value = newValue
        }
        PasswordField(value = password.value){ newValue ->
            password.value = newValue
        }
        Button(onClick = { auth(email.value,password.value,isLogIn.value)}) {
            if(isLogIn.value){
                Text("Iniciar sesión")
            }else{
                Text("Registrate")
            }
        }
    }
}

@Composable
fun EmailField(value:String,changed: (String)->Unit){
    TextField(value = value, onValueChange = changed)
}

@Composable
fun PasswordField(value:String,changed: (String)->Unit){
    TextField(value = value, onValueChange = changed)
}

@Preview(showBackground = true)
@Composable
fun PreviewAuthActivity(){
    AuthActivityContent(){ email, password,isLogin ->
        print(email)
        print(password)
    }
}