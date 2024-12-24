package com.enlevo.taskly_flow.controller

import com.enlevo.taskly_flow.domain.Task
import com.enlevo.taskly_flow.domain.TaskDTO
import com.enlevo.taskly_flow.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/taskly")
class TasksController(private val service: TaskService) {

    @PostMapping("/tasks")
    fun addTask(
        @RequestBody task: TaskDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Task> {
        val createdTask = service.addTask(task)

        val location = uriBuilder.path("/tasks/{id}").buildAndExpand(createdTask.id).toUri()

        return ResponseEntity.created(location).body(createdTask)
    }

    @GetMapping("/tasks")
    fun getTask(): ResponseEntity<List<Task>> {
        val tasks = service.getTask()
        return ResponseEntity.ok(tasks)
    }

    @PatchMapping("/tasks/{id}")
    fun updateTask(
        @PathVariable id: Long,
        @RequestBody update: Map<String, Any>
    ): ResponseEntity<Task> {
        return ResponseEntity.ok(Task(TaskDTO(title = "", description = "", completed = false)))
    }

}