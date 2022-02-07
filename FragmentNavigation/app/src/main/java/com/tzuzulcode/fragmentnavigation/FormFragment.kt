package com.tzuzulcode.fragmentnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController

class FormFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_form, container, false)
        val goDetailsButton = rootView.findViewById<Button>(R.id.go_details_button)


        goDetailsButton.setOnClickListener {
            // Haciendo navegacion
            val nameText = rootView.findViewById<EditText>(R.id.name).text
            val professionText = rootView.findViewById<EditText>(R.id.profession).text
            val ageText = rootView.findViewById<EditText>(R.id.age).text

            if(nameText.isEmpty() || professionText.isEmpty() || ageText.isEmpty()){
                Toast.makeText( activity,"Rellena los campos",Toast.LENGTH_SHORT).show()
            }else{
                val name = nameText.toString()
                val profession = professionText.toString()
                val age = ageText.toString().toInt()
                val action = FormFragmentDirections.actionFormFragmentToDetailsFragment(name,profession,age)
                rootView.findNavController().navigate(action)
            }
        }

        return rootView
    }
}