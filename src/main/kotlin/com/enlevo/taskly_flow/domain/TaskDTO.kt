package com.enlevo.taskly_flow.domain

data class TaskDTO(
    val title: String,
    val description: String,
    val completed: Boolean = false
)