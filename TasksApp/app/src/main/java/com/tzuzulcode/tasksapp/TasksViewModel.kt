package com.tzuzulcode.tasksapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao):ViewModel() {

    var newTask = ""

    val tasks = dao.getAll() // leemos de la base de datos
    /*val tasksString = Transformations.map(tasks){
            tasks->formatTasks(tasks)
    }*/

    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask:LiveData<Long?>
        get() = _navigateToTask

    fun addTask(){
        print("Agregando task")
        viewModelScope.launch {
            val task = Task()
            task.name = newTask
            dao.insert(task)
        }
    }

    fun onTaskClicked(taskId:Long){
        _navigateToTask.value = taskId
    }

    fun onTaskNavigated(){
        _navigateToTask.value = null
    }

    /*fun formatTasks(tasks:List<Task>):String{
        return tasks.fold(""){
            str,item->str+"\n"+formatTask(item)
        }
    }

    fun formatTask(task:Task):String{
        var str = "ID: ${task.id}"
        str+="\nName: ${task.name}"
        str+="\nComplete: ${task.done}"

        return str
    }*/
}