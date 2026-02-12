package com.example.taskflow.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskflow.android.data.local.model.TodoEntity

@Database(entities = [TodoEntity::class],version = 1)
abstract class TodoDatabase : RoomDatabase(){

    abstract fun todoDao() : TodoDao
}