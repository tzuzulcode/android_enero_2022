package com.tzuzulcode.fragmentnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
            val name = rootView.findViewById<EditText>(R.id.name).text.toString()
            val profession = rootView.findViewById<EditText>(R.id.profession).text.toString()
            val age = rootView.findViewById<EditText>(R.id.age).text.toString().toInt()
            val action = FormFragmentDirections.actionFormFragmentToDetailsFragment(name,profession,age)
            rootView.findNavController().navigate(action)
        }

        return rootView
    }
}