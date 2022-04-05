package com.tzuzulcode.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tzuzulcode.chat.ui.theme.ChatTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun MainActivityContent(){
    val counter = remember {
        mutableStateOf(0)
    }

    Column {
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = "Imagen de telefono",
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            //contentScale = ContentScale.Crop
        )

        Text("Numero de veces presionado: ${counter.value}")

        /*TestButton({
            counter.value+=1
        })*/

        TestButton{
            counter.value+=1
        }

        Hello("Hola, esto es Jetpack Compose")
        Hello("Bienvenidos")
        ListOfStudents(names = listOf("Gonzalo","Miguel","Federico","Edgar","Vinicio"))
    }
}


//Mi primer composable. Normalmente empiezan con mayuscula
@Composable
fun Hello(name: String){
    return Text(name)
}

@Composable
fun ListOfStudents(names:List<String>){
    for(name in names){
        Text("Hola $name!")
    }
}

@Composable
fun TestButton(add:()->Unit){
    Button(onClick = add) {
        Text("Presionar")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity(){
    MainActivityContent()
}