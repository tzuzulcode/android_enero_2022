package com.tzuzulcode.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


class AuthActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AuthActivityContent()
        }
    }
}


@Composable
fun AuthActivityContent(){
    val email = remember{
        mutableStateOf("")
    }
    val password = remember{
        mutableStateOf("")
    }

    fun onChanged(newValue:String){}

    Column {
        EmailField(value = email.value){ newValue ->
            email.value = newValue
        }
        PasswordField(value = password.value){ newValue ->
            password.value = newValue
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Iniciar sesión")
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
    AuthActivityContent()
}