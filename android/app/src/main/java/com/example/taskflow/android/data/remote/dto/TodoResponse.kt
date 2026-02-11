package com.example.taskflow.android.data.remote.dto

data class TodoResponse(
    val completed: Boolean,
    val id: Int,
    val title: String
)