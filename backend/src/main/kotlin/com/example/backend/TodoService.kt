package com.example.backend

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
class TodoService(
    private val repository: TodoRepository
) {

    fun getAllTodos(
        @RequestParam(required = false)
        completed : Boolean?
    ) : List<TodoResponse>{
        val todos = if (completed != null){
            repository.findByCompleted(completed)
        }else{
            repository.findAll()
        }
        val todosResponse = todos.map { it.toResponse() }
        return todosResponse
    }

}