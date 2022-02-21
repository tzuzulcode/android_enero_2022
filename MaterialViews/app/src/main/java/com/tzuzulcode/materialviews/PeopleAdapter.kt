package com.tzuzulcode.materialviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PeopleAdapter(private val context:Context,private val dataSource: ArrayList<Person>):BaseAdapter() {
    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.person_item,parent,false)

        val name = view.findViewById<TextView>(R.id.name)
        val age = view.findViewById<TextView>(R.id.age)
        val city = view.findViewById<TextView>(R.id.city)

        val person = getItem(position) as Person

        print(person.nombre)

        name.text = person.nombre
        age.text = person.edad.toString()
        city.text = person.city

        return view
    }


}