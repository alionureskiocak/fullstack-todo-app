package com.example.backend

import jakarta.validation.constraints.NotBlank

class TodoUpdateRequest(
    @field:NotBlank(message = "This field can't be blank!")
    val title : String,
    val completed : Boolean
)