package com.tzuzulcode.tasksapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzuzulcode.tasksapp.data.source.local.TaskDao
import kotlinx.coroutines.launch

class EditTaskViewModel(taskId:Long, val dao: TaskDao):ViewModel() {
    val task = dao.getTaskWithSteps(taskId)

    private val _navigateToList= MutableLiveData<Boolean>()
    val navigateToList: LiveData<Boolean>
        get() = _navigateToList

    fun updateTask(){
        viewModelScope.launch {
            dao.update(task.value?.task!!)
            _navigateToList.value = true
        }
    }

    fun deleteTask(){
        viewModelScope.launch {
            dao.delete(task.value?.task!!)
            _navigateToList.value = true
        }
    }


    fun onNavigatedToList(){
        _navigateToList.value = false
    }
}