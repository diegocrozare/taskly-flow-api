package com.enlevo.taskly_flow.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "users")
@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val login: String,
    val password: String,

    val createdAt: LocalDateTime = LocalDateTime.now()

) {
    constructor(dto: User) : this(
        login = dto.login,
        password = dto.password,
    )
}