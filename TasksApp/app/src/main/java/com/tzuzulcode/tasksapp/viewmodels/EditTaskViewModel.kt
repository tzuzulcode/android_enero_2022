package com.tzuzulcode.tasksapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzuzulcode.tasksapp.data.source.local.StepDao
import com.tzuzulcode.tasksapp.data.source.local.TaskDao
import com.tzuzulcode.tasksapp.models.Step
import kotlinx.coroutines.launch

class EditTaskViewModel(taskId:Long, val dao: TaskDao,val stepDao: StepDao):ViewModel() {
    val task = dao.getTaskWithSteps(taskId)

    var newStep = ""

    private val _navigateToList= MutableLiveData<Boolean>()
    val navigateToList: LiveData<Boolean>
        get() = _navigateToList

    fun addStep(){
        viewModelScope.launch {
            var step = Step()
            step.name = newStep
            step.taskId = task.value?.task?.id ?: 0
            stepDao.insert(step)
        }
    }

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