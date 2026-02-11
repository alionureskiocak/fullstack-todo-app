package com.example.taskflow.android.presentation

import com.example.taskflow.android.domain.model.TodoItem

sealed interface TodoEvent {

    data class OnAddClick(val todo : TodoItem)
    data class OnUpdateClick(val todo : TodoItem)
    data class OnDeleteClick(val todo : TodoItem)

    data class OnTitleChanged(val title : String)
    data class OnCheckedChanged(val checked : Boolean)
}