package com.example.taskflow.android.presentation

import com.example.taskflow.android.domain.model.TodoItem

sealed interface TodoEvent {

    data class OnAddClick(val title : String) : TodoEvent
    data class OnUpdateClick(val todo : TodoItem): TodoEvent
    data class OnDeleteClick(val todo : TodoItem): TodoEvent

    data class OnTitleChanged(val title : String): TodoEvent
    data class OnCheckedChanged(val checked : Boolean): TodoEvent
}