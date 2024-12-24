package com.enlevo.taskly_flow.service

import com.enlevo.taskly_flow.domain.User
import com.enlevo.taskly_flow.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun login(user: User) {
        repository.save(user)
    }

    fun register(user: User): User {
        return repository.save(user)
    }

}