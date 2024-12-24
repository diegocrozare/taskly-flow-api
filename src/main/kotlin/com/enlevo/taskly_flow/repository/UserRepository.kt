package com.enlevo.taskly_flow.repository

import com.enlevo.taskly_flow.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}