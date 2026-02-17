package com.example.taskflow.android.data.repository

import android.util.Log
import com.example.taskflow.android.data.local.TodoDao
import com.example.taskflow.android.data.mappers.toDomain
import com.example.taskflow.android.data.mappers.toEntity
import com.example.taskflow.android.data.remote.TodoAPI
import com.example.taskflow.android.data.remote.dto.TodoCreateRequest
import com.example.taskflow.android.data.remote.dto.TodoUpdateRequest
import com.example.taskflow.android.domain.model.TodoItem
import com.example.taskflow.android.domain.repository.TodoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class TodoRepositoryImpl @Inject constructor(
    private val api : TodoAPI,
    private val dao : TodoDao
) : TodoRepository{

    override fun getTodosFromRoom(completed: Boolean?): Flow<List<TodoItem>> {
        return dao.getTodosFromRoom()
            .map { it.map {
                it.toDomain()
            } }
    }

    override suspend fun refreshTodos(completed : Boolean?){

        try {
            val remoteTodos = api.getTodos(completed)
            dao.deleteTodos()
            dao.addTodos(remoteTodos.map { it.toEntity() })
        }catch (e: Exception){
            Log.d("error",e.localizedMessage)
        }
    }

    override suspend fun createTodo(title: String): TodoItem {

        val request = TodoCreateRequest(title)
        val response = api.createTodo(request)
        dao.addTodo(response.toEntity())
        return response.toDomain()
    }

    override suspend fun updateTodo(
        id: Long,
        title: String,
        completed: Boolean
    ) : TodoItem{

        val request = TodoUpdateRequest(title,completed)
        val response = api.updateTodo(id,request)
        dao.addTodo(response.toEntity())
        return response.toDomain()
    }

    override suspend fun deleteTodo(id: Long) {
        api.deleteTodo(id)
        dao.deleteTodo(id)
    }
}