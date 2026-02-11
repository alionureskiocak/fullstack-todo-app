package com.example.backend

fun Todo.toResponse() : TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        completed = completed
    )
}

fun TodoResponse.toDomain() : Todo{
    return Todo(
        id = id,
        title = title,
        completed = completed
    )
}