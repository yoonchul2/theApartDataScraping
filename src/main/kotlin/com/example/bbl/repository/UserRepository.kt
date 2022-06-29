package com.example.bbl.repository

import com.example.bbl.entity.user.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {
}