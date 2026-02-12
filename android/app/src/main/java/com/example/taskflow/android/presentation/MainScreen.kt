package com.example.taskflow.android.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskflow.android.domain.model.TodoItem

@Composable
fun MainScreen(viewModel: TodoViewModel = hiltViewModel()) {


    val state by viewModel.state.collectAsState()
    val todos = state.todos
    val currentTodo = state.currentTodo

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(todos) { todo ->
                TodoRow(todo = todo, onCheckedChange = { checked ->
                    val updatedTodo = todo.copy(completed = checked)
                    viewModel.onEvent(TodoEvent.OnUpdateClick(updatedTodo))
                })
            }
        }

    }
}

@Composable
fun TodoRow(todo : TodoItem,onCheckedChange : (Boolean) -> Unit) {
    val title = todo.title
    val checked = todo.completed

    Row{
        Text(text = title, fontSize = 14.sp,modifier = Modifier.padding(2.dp))
        Checkbox(checked = checked, onCheckedChange = {
            onCheckedChange(it)
        })
    }


}











