package com.example.taskflow.android.domain.model

data class TodoItem(
    var completed: Boolean,
    val id: Long,
    var title: String
)