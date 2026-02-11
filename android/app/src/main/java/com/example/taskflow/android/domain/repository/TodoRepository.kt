package com.example.taskflow.android.domain.repository

import com.example.taskflow.android.domain.model.TodoItem

interface TodoRepository {

    suspend fun getTodos(completed : Boolean?) : List<TodoItem>
    suspend fun createTodo(title : String) : TodoItem
    suspend fun updateTodo(id : Long, title : String, completed : Boolean) : TodoItem
    suspend fun deleteTodo(id : Long)
}