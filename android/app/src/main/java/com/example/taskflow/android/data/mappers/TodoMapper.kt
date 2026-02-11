package com.example.taskflow.android.data.mappers

import com.example.taskflow.android.data.remote.dto.TodoResponse
import com.example.taskflow.android.domain.model.TodoItem

fun TodoResponse.toDomain() : TodoItem{
    return TodoItem(
        id = id,
        title = title,
        completed = completed
    )
}

fun TodoItem.toResponse() : TodoResponse{
    return TodoResponse(
        id = id,
        title = title,
        completed = completed
    )
}