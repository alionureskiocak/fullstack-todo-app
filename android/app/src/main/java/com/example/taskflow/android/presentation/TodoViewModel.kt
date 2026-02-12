package com.example.taskflow.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskflow.android.domain.model.TodoItem
import com.example.taskflow.android.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel(){

    private val _effect = MutableSharedFlow<TodoEffect>()
    val effect : SharedFlow<TodoEffect> = _effect.asSharedFlow()

    private val _state = MutableStateFlow<TodoState>(TodoState())
    val state : StateFlow<TodoState> = _state.asStateFlow()

    init {
        getTodos()
        refresh()
    }

     fun refresh() {
        viewModelScope.launch {
           repository.refreshTodos(null)
        }
    }
    fun onEvent(event : TodoEvent){
        when(event){
            is TodoEvent.OnGetTodos -> getTodos()
            is TodoEvent.OnAddClick -> createTodo(event.title)
            is TodoEvent.OnUpdateClick -> updateTodo(event.todo)
            is TodoEvent.OnDeleteClick -> deleteTodo(event.todo)
            is TodoEvent.OnTitleChanged -> handleTitleChanged(event.title)
            is TodoEvent.OnCheckedChanged -> handleCheckedChanged(event.checked)
        }
    }

    fun handleTitleChanged(title : String){
       _state.value = _state.value.copy(
           currentTodo = _state.value.currentTodo.copy(
               title = title
           )
       )
    }

    fun handleCheckedChanged(checked: Boolean) {
        _state.value = _state.value.copy(
            currentTodo = _state.value.currentTodo.copy(
                completed = checked
            )
        )
    }



    fun getTodos() {
        viewModelScope.launch {
            repository.getTodosFromRoom(null).collect {
                _state.value = _state.value.copy(
                    todos = it
                )
            }
        }
    }

    fun createTodo(title : String){
        viewModelScope.launch {
            repository.createTodo(title)
        }
    }

    fun updateTodo(todo : TodoItem){
        viewModelScope.launch {
            repository.updateTodo(todo.id,todo.title,todo.completed)
        }
    }

    fun deleteTodo(todo : TodoItem){
        viewModelScope.launch {
            repository.deleteTodo(todo.id)
        }
    }

}


data class TodoState(
    val todos : List<TodoItem> = emptyList(),
    val currentTodo : TodoItem = TodoItem(
        id = -1,
        title = "",
        completed = false
    )
)