package com.tzuzulcode.tasksapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
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

    class TaskItemViewHolder(val rootView: CardView):RecyclerView.ViewHolder(rootView){

        val taskName = rootView.findViewById<TextView>(R.id.task_name)
        val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        fun bind(item:Task){
            taskName.text = item.name
            taskDone.isChecked = item.done
        }

        companion object{
            fun inflateFrom(parent: ViewGroup):TaskItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item,parent,false) as CardView
                return TaskItemViewHolder(view)
            }
        }
    }
}