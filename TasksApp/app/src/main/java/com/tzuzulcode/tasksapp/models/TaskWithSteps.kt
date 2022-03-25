package com.tzuzulcode.tasksapp.models

import androidx.room.Embedded
import androidx.room.Relation

data class TaskWithSteps(
    @Embedded val task:Task,
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    val steps:List<Step>
)
