package com.enlevo.taskly_flow.service

import com.enlevo.taskly_flow.domain.Task
import com.enlevo.taskly_flow.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) {

    fun addTask(task: Task): Task {
        return repository.save(task)
    }

}