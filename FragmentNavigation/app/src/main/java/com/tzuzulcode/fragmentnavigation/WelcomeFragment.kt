package com.tzuzulcode.fragmentnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_welcome, container, false)
        val goFormButton = rootView.findViewById<Button>(R.id.go_form_button)
        goFormButton.setOnClickListener {
            // Haciendo navegacion
            rootView.findNavController().navigate(R.id.action_welcomeFragment_to_formFragment)
        }



        return rootView
    }
}