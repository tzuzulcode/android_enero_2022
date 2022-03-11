package com.tzuzulcode.tasksapp
import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Insert
    fun insertAll(tasks:List<Task>)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM tasks WHERE id= :taskId")
    fun get(taskId:Long)

    @Query("SELECT * FROM tasks")
    fun getAll()

}