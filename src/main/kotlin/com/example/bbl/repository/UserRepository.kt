package com.example.bbl.repository

import com.example.bbl.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}