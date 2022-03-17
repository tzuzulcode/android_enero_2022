package com.tzuzulcode.tasksapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class TaskItemAdapter: Adapter<TaskItemAdapter.TaskItemViewHolder>() {
    var data = listOf<Task>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder,position:Int){
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent:ViewGroup,viewType: Int):TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun getItemCount() = data.size

    class TaskItemViewHolder(val rootView: TextView):RecyclerView.ViewHolder(rootView){

        fun bind(item:Task){
            rootView.text = item.name
        }

        companion object{
            fun inflateFrom(parent: ViewGroup):TaskItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item,parent,false) as TextView
                return TaskItemViewHolder(view)
            }
        }
    }
}