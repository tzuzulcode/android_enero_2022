package com.tzuzulcode.tasksapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tzuzulcode.tasksapp.databinding.StepItemBinding
import com.tzuzulcode.tasksapp.models.Step


class StepItemAdapter: ListAdapter<Step,StepItemAdapter.StepItemViewHolder>(StepDiffItemCallback()) {

    class StepItemViewHolder(val binding:StepItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: Step
                 //,clickListener:(id:Long)->Unit
        ){
            binding.step = item
            //binding.root.setOnClickListener {}
        }
        companion object{
            fun inflateFrom(parent:ViewGroup):StepItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding = StepItemBinding.inflate(layoutInflater,parent,false)

                return StepItemViewHolder(binding)


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StepItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: StepItemViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

}