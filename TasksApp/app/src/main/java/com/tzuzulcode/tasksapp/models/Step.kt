package com.tzuzulcode.tasksapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "steps")
data class Step(
    @PrimaryKey val id:Long,
    val name:String,
    val taskId:Long
)
