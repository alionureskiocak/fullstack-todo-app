package com.example.taskflow.android.data.repository

import com.example.taskflow.android.data.mappers.toDomain
import com.example.taskflow.android.data.remote.TodoAPI
import com.example.taskflow.android.data.remote.dto.TodoCreateRequest
import com.example.taskflow.android.data.remote.dto.TodoUpdateRequest
import com.example.taskflow.android.domain.model.TodoItem
import com.example.taskflow.android.domain.repository.TodoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TodoRepositoryImpl @Inject constructor(
    private val api : TodoAPI
) : TodoRepository{
    override suspend fun getTodos(completed : Boolean?): List<TodoItem> {
        return api.getTodos(completed).map{ it.toDomain() }
    }

    override suspend fun createTodo(title: String): TodoItem {

        val request = TodoCreateRequest(title)
        val response = api.createTodo(request)
        return response.toDomain()
    }

    override suspend fun updateTodo(
        id: Long,
        title: String,
        completed: Boolean
    ) : TodoItem{

        val request = TodoUpdateRequest(title,completed)
        val response = api.updateTodo(id,request)
        return response.toDomain()
    }

    override suspend fun deleteTodo(id: Long) {
        api.deleteTodo(id)
    }
}