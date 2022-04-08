package com.tzuzulcode.chat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.Observer
import com.tzuzulcode.chat.viewmodel.HomeViewModel

class ChatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = HomeViewModel()

        viewModel.isLoggedIn.observe(this, Observer {
            if(!it){
                this.finish()
            }
        })

        setContent {
            ChatsActivityContent(){
                viewModel.logout()
            }
        }
    }
}

@Composable
fun ChatsActivityContent(logout:()->Unit){
    var isMenuOpen = remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title={Text("My chats")},
        actions={
            IconButton(onClick = {
                isMenuOpen.value = !isMenuOpen.value
            }) {
                Icon(Icons.Default.AccountCircle,"Perfil")
            }
            DropdownMenu(expanded = isMenuOpen.value, onDismissRequest = { isMenuOpen.value=false }) {
                DropdownMenuItem(onClick = {
                    logout()
                    isMenuOpen.value=false
                }) {
                    Icon(Icons.Default.ExitToApp,"Salir")
                }
            }
        }
    )
}