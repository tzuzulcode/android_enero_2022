package com.tzuzulcode.tasksapp.adapters

import androidx.recyclerview.widget.DiffUtil
import com.tzuzulcode.tasksapp.models.Step

class StepDiffItemCallback:DiffUtil.ItemCallback<Step>() {
    override fun areItemsTheSame(oldItem: Step, newItem: Step) = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: Step, newItem: Step) = (oldItem==newItem)
}