package com.tzuzulcode.tasksapp

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao):ViewModel() {

    var newTask = ""

    private val tasks = dao.getAll() // leemos de la base de datos
    val tasksString = Transformations.map(tasks){
            tasks->formatTasks(tasks)
    }

    fun addTask(){
        print("Agregando task")
        viewModelScope.launch {
            val task = Task()
            task.name = newTask
            dao.insert(task)
        }
    }

    fun formatTasks(tasks:List<Task>):String{
        return tasks.fold(""){
            str,item->str+"\n"+formatTask(item)
        }
    }

    fun formatTask(task:Task):String{
        var str = "ID: ${task.id}"
        str+="\nName: ${task.name}"
        str+="\nComplete: ${task.done}"

        return str
    }
}