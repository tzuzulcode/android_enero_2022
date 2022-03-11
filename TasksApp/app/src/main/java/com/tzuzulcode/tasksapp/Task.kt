package com.tzuzulcode.tasksapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// @ significa una anotación
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name="name")
    var name:String = "",
    @ColumnInfo(name="done")
    var done:Boolean = false
    //Type converters
)
