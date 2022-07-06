package com.matching.main.repository


import com.matching.main.entity.user.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {
}