package com.tzuzulcode.tasksapp.adapters

import androidx.recyclerview.widget.DiffUtil
import com.tzuzulcode.tasksapp.models.Task

class TaskDiffItemCallback:DiffUtil.ItemCallback<Task>() {
    /*override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {

        return (oldItem.id==newItem.id)
    }*/

    override fun areItemsTheSame(oldItem: Task, newItem: Task)=(oldItem.id==newItem.id)

    override fun areContentsTheSame(oldItem: Task, newItem: Task) = (oldItem==newItem)

}