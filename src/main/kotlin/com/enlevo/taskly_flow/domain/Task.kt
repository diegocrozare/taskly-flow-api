package com.enlevo.taskly_flow.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "jobs")
@Entity
data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val title: String,
    val description: String,
    val completed: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now()
)