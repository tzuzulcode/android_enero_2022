package com.tzuzulcode.materialviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

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

        return view
    }
}