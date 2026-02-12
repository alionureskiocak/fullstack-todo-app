package com.example.taskflow.android.domain.repository

import com.example.taskflow.android.domain.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

     fun getTodos(completed : Boolean?) : Flow<List<TodoItem>>
    suspend fun createTodo(title : String) : TodoItem
    suspend fun updateTodo(id : Long, title : String, completed : Boolean) : TodoItem
    suspend fun deleteTodo(id : Long)
}