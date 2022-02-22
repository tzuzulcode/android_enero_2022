package com.tzuzulcode.materialviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        val thisActivity = activity as AppCompatActivity

        thisActivity.setSupportActionBar(toolbar)

        val lista = view.findViewById<ListView>(R.id.list_view)

        val listaAlumnos = arrayListOf<Person>(Person("Edgar",24,"Bogota"),Person("Federico",22,"Florida"))

        print(listaAlumnos)

        val adapter = PeopleAdapter(thisActivity,listaAlumnos)

        lista.adapter = adapter

        // Reaccionando a la interacción

        val fab = view.findViewById<FloatingActionButton>(R.id.button_send)
        val food = view.findViewById<RadioGroup>(R.id.food)
        val queso = view.findViewById<CheckBox>(R.id.queso)
        val entrega = view.findViewById<Switch>(R.id.entrega_rapida)
        val picante = view.findViewById<ToggleButton>(R.id.picante)
        val paraLlevar = view.findViewById<Chip>(R.id.para_llevar)
        val soloRestaurante = view.findViewById<Chip>(R.id.solo_restaurante)


        fab.setOnClickListener{
            val foodType = food.checkedRadioButtonId
            if(foodType==-1){
                Toast.makeText(activity,"Ninguna comida seleccionada",Toast.LENGTH_SHORT).show()
            }else{
                var text = (when(foodType){
                    R.id.spaguetti -> "Spaguetti"
                    R.id.hamburhuesa -> "Hamburguesa"
                    R.id.arepa -> "Arepa"
                    else -> "Tacos"
                })

                var message = "Comida: $text. Queso: ${queso.isChecked}." +
                        " Entrega: ${entrega.isChecked}. Picante: ${picante.isChecked}"

                if(paraLlevar.isChecked){
                    message += " Para llevar"
                }else{
                    message += " Para restaurante"
                }

                Snackbar.make(fab,message,Snackbar.LENGTH_LONG).show()

            }
        }

        return view

        //Binding
    }
}