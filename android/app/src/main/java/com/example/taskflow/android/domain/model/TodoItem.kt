package com.example.taskflow.android.domain.model

data class TodoItem(
    val completed: Boolean,
    val id: Int,
    val title: String
)