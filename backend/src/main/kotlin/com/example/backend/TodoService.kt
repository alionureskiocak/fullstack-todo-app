package com.example.backend

import org.springframework.stereotype.Service

@Service
class TodoService(
    private val repository: TodoRepository
) {

    fun add(request: TodoCreateRequest) : TodoResponse {
        val todo = Todo(
            title = request.title,
            completed = false
            )
        val savedTodo = repository.save(todo)
        return savedTodo.toResponse()

    }

    fun updateTodo(
        id : Long,
        request : TodoUpdateRequest
    ) : TodoResponse{
        val todo = repository.findById(id).orElseThrow{RuntimeException("Couldn't find todo!")}
        todo.title = request.title
        todo.completed = request.completed
        return repository.save(todo).toResponse()
    }

    fun deleteTodo(
        id : Long
    ) : TodoResponse{
        val todo = repository.findById(id).orElseThrow{RuntimeException("Couldn't find todo!")}
        repository.delete(todo)
        return todo.toResponse()
    }



    fun getAllTodos(
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