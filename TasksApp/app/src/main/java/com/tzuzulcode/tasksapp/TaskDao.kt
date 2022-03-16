package com.tzuzulcode.tasksapp
import androidx.lifecycle.LiveData
import androidx.room.*

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

}