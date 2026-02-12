package com.example.taskflow.android.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = false)
    val id : Long = 0,
    val title : String,
    val completed : Boolean,
    val isSynced : Boolean = true
)