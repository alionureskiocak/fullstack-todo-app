package com.example.backend

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    val title : String = "",
    val completed : Boolean = false,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(nullable = false)
    val updatedDate : LocalDateTime? = null
)