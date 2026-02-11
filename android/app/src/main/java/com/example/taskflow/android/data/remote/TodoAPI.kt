package com.example.taskflow.android.data.remote

import androidx.room.Delete
import com.example.taskflow.android.data.remote.dto.TodoCreateRequest
import com.example.taskflow.android.data.remote.dto.TodoResponse
import com.example.taskflow.android.data.remote.dto.TodoUpdateRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TodoAPI {


    @GET("/api/todos")
    suspend fun getTodos(
        @Query("completed") completed : Boolean?
    ) : List<TodoResponse>

    @POST("/api/todos")
    suspend fun createTodo(
        @Body request : TodoCreateRequest
    ) : TodoResponse

    @PUT("/api/todos/{id}")
    suspend fun updateTodo(
        @Path("id") id : Long,
        @Body request: TodoUpdateRequest
    ) : TodoResponse

    @DELETE("/api/todos/{id}")
    suspend fun deleteTodo(
        @Path("id") id : Long
    )

}