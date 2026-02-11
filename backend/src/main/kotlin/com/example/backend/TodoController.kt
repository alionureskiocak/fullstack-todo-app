package com.example.backend

import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {

    @PostMapping
    fun addTodo(
        @Valid @RequestBody
        request: TodoCreateRequest) : TodoResponse{
        return todoService.addTodo(request)
    }

    @PutMapping("/{id}")
    fun updateTodo(
        @PathVariable id : Long,
        @RequestBody request: TodoUpdateRequest
    ) : TodoResponse{
        return todoService.updateTodo(id,request)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(
        @PathVariable id : Long
    ) : TodoResponse{
        return todoService.deleteTodo(id)
    }
}