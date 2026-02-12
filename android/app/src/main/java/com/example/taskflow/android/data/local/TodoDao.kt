package com.example.taskflow.android.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.taskflow.android.data.local.model.TodoEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    fun getTodosFromRoom() : List<TodoEntity>

    @Insert
    suspend fun addTodo(todoEntity: TodoEntity)

    @Delete
    suspend fun deleteTodo(todoEntity: TodoEntity)

    @Insert
    suspend fun addTodos(todos : List<TodoEntity>)

    @Delete
    suspend fun deleteTodos(todos : List<TodoEntity>)
}