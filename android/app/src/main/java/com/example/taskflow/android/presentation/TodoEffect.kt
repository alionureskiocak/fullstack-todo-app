package com.example.taskflow.android.presentation

sealed class TodoEffect {

    data class ShowToast(val message : String)
}