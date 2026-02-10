package com.example.backend

import jakarta.validation.constraints.NotBlank

class TodoCreateRequest(
    @field:NotBlank(message = "This field can't be blank!")
    val title : String
)