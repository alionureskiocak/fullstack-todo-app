package com.example.backend

import jakarta.validation.constraints.NotBlank

data class TodoCreateRequest(
    @field:NotBlank(message = "This field can't be blank!")
    val title : String
)