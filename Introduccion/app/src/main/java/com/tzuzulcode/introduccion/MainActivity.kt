package com.tzuzulcode.introduccion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    /*
    companion object{
        var context: Context? = null
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate
        setContentView(R.layout.constraint_layout)
        /*if(context==null){
            context = this
        }*/
        //context.startActivity(Intent(context,Activity2::class.java))

        /*val acceptButton = findViewById<Button>(R.id.button) // referencia al botón
        val spinner = findViewById<Spinner>(R.id.spinner) // referencia al botón
        val selectedStudent = findViewById<TextView>(R.id.option) // referencia al botón

        acceptButton.setOnClickListener {
            //Esto es un lambda
            val student = "El estudiante seleccionado es: ${spinner.selectedItem.toString()}"
            selectedStudent.text = student
        }
         */


    }
}