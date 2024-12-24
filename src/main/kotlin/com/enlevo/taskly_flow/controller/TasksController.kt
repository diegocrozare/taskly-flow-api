package com.enlevo.taskly_flow.controller

import com.enlevo.taskly_flow.domain.Task
import com.enlevo.taskly_flow.domain.TaskDTO
import com.enlevo.taskly_flow.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/tasks")
class TasksController(private val service: TaskService) {

    @PostMapping
    fun addTask(@RequestBody task: TaskDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<Task> {
        val createdTask = service.addTask(task)

        val location = uriBuilder
            .path("/tasks/{id}")
            .buildAndExpand(createdTask.id)
            .toUri()

        return ResponseEntity.created(location).body(createdTask)
    }

}