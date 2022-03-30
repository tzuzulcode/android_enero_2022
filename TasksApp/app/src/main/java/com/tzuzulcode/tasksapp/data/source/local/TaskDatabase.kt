package com.tzuzulcode.tasksapp.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tzuzulcode.tasksapp.models.Step
import com.tzuzulcode.tasksapp.models.Task
import com.tzuzulcode.tasksapp.models.TaskWithSteps

@Database(entities = [Task::class,Step::class], version = 4, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
    abstract val stepDao: StepDao

    //Similar a definir métodos estáticos
    companion object{
        //Volatile: Los cambios en esta propiedad son visibles inmediatamente a otros hilos(threads)
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        //Singleton: Design pattern
        fun getInstance(context: Context): TaskDatabase {
            var instance = INSTANCE
            if(instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "tasks_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
            }

            return instance
        }
    }

    // public y singleton Tzuzul
    // protected Aremi
    // private Edgar
    // static Federico
    // final Gonzalo
    // abstract Julio
    // interface Vinicio
}