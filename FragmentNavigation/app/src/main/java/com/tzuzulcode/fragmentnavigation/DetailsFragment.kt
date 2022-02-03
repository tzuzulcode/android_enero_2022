package com.tzuzulcode.fragmentnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)
        val goHomeButton = rootView.findViewById<Button>(R.id.go_home_button)
        val detailsText = rootView.findViewById<TextView>(R.id.details)

        val bundle = DetailsFragmentArgs.fromBundle(requireArguments())

        val name = bundle.name
        val profession = bundle.profession
        val age = bundle.age

        detailsText.text = "Registro exitoso! ${name} (${age}). Profesión: ${profession}"

        goHomeButton.setOnClickListener {
            // Haciendo navegacion
            rootView.findNavController().navigate(R.id.action_detailsFragment_to_welcomeFragment)
        }

        return rootView
    }
}