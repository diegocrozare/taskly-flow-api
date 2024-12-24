package com.enlevo.taskly_flow.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "tasks")
@Entity

data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,
    val description: String,
    val completed: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    constructor(dto: TaskDTO) : this(
        id = null,
        title = dto.title,
        description = dto.description,
        completed = dto.completed
    )
}