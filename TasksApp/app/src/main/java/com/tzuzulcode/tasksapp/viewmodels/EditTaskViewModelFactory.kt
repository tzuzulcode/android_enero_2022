package com.tzuzulcode.tasksapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tzuzulcode.tasksapp.data.source.local.StepDao
import com.tzuzulcode.tasksapp.data.source.local.TaskDao
import java.lang.IllegalArgumentException

class EditTaskViewModelFactory(private val taskId:Long,private val dao: TaskDao,private val stepDao:StepDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EditTaskViewModel::class.java)){
            return EditTaskViewModel(taskId,dao,stepDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel")
    }


}