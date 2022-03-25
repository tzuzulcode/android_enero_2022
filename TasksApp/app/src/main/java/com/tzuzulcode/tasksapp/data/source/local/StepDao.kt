package com.tzuzulcode.tasksapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tzuzulcode.tasksapp.models.Step

@Dao
interface StepDao {
    @Insert
    suspend fun insert(step: Step)

    @Update
    suspend fun update(step: Step)

    @Delete
    suspend fun delete(step: Step)

    @Query("SELECT * FROM steps WHERE taskId = :taskId")
    fun getByTaskId(taskId:Long):LiveData<List<Step>>
}