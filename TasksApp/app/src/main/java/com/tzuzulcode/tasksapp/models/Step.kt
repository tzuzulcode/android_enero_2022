package com.tzuzulcode.tasksapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "steps")
data class Step(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    var name:String = "",
    var taskId:Long = 0L
)
