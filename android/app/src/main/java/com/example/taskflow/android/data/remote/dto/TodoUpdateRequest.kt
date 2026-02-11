package com.example.taskflow.android.data.remote.dto

data class TodoUpdateRequest(
    val title : String,
    val completed : Boolean
)