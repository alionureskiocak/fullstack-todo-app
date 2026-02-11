package com.example.backend

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    var title : String = "",
    var completed : Boolean = false,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val createdDate: LocalDateTime? = LocalDateTime.now(),

    @LastModifiedDate
    @Column(nullable = false)
    val updatedDate : LocalDateTime? = LocalDateTime.now()
)