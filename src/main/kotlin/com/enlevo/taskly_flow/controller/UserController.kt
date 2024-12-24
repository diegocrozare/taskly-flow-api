package com.enlevo.taskly_flow.controller

import com.enlevo.taskly_flow.domain.User
import com.enlevo.taskly_flow.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/taskly")
class UserController(private val service: UserService) {

    @PostMapping("/login")
    fun login(@RequestBody user: User) : ResponseEntity<String> {
        if (user.login == "root" && user.password == "root") {
            return ResponseEntity.ok("Login realizado com sucesso")
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos")
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody user: User, uriBuilder: UriComponentsBuilder) : ResponseEntity<Void> {
        val createdUser = service.register(user)

        val location = uriBuilder.path("/taskly/users/{id}").buildAndExpand(createdUser.id).toUri()

        return ResponseEntity.created(location).build()
    }

}