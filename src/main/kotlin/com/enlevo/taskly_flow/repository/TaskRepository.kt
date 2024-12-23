package com.enlevo.taskly_flow.repository

import com.enlevo.taskly_flow.domain.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long> {
}