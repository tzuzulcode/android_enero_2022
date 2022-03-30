package com.tzuzulcode.tasksapp.data.source.local
import androidx.lifecycle.LiveData
import androidx.room.*
import com.tzuzulcode.tasksapp.models.Task
import com.tzuzulcode.tasksapp.models.TaskWithSteps

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Insert
    suspend fun insertAll(tasks:List<Task>)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks WHERE id= :taskId")
    fun get(taskId:Long):LiveData<Task>

    @Query("SELECT * FROM tasks")
    fun getAll():LiveData<List<Task>>

    @Transaction
    @Query("SELECT * FROM tasks WHERE id= :taskId")
    fun getTaskWithSteps(taskId:Long):LiveData<TaskWithSteps>

}