package com.example.taskflow.android.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskflow.android.data.local.model.TodoEntity
import kotlinx.coroutines.flow.Flow
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    fun getTodosFromRoom() : Flow<List<TodoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todoEntity: TodoEntity)

    @Query("DELETE FROM todos WHERE id = :id")
    suspend fun deleteTodo(id : Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodos(todos : List<TodoEntity>)

    @Query("DELETE FROM todos")
    suspend fun deleteTodos()
}