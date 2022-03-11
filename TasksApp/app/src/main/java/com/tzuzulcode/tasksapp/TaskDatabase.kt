package com.tzuzulcode.tasksapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao

    //Similar a definir métodos estáticos
    companion object{

    }

    // public y singleton Tzuzul
    // protected Aremi
    // private Edgar
    // static Federico
    // final Gonzalo
    // abstract Julio
    // interface Vinicio
}