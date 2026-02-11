package com.example.backend

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo,Long> {

    fun findByCompleted(completed : Boolean) : List<Todo>

}