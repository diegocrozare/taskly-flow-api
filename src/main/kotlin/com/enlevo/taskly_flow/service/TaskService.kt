package com.enlevo.taskly_flow.service

import com.enlevo.taskly_flow.domain.Task
import com.enlevo.taskly_flow.domain.TaskDTO
import com.enlevo.taskly_flow.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) {

    fun addTask(taskDTO: TaskDTO): Task {
        val task = Task(taskDTO)
        return repository.save(task)
    }

    fun getTask(): List<Task> {
        return repository.findAll()
    }

}