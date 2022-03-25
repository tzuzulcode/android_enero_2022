package com.tzuzulcode.tasksapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

// @ significa una anotación
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name="name")
    var name:String = "",
    @ColumnInfo(name="done")
    var done:Boolean = false,
    //Type converters
    @ColumnInfo(name = "date")
    var date:String = "",
    @Ignore
    var _date: Date? = null
)

/*class Date{
    constructor(){
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(task.date)
    }
}*/
