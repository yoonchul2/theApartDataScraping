package com.bokbuin.main.repository

import com.bokbuin.main.entity.user.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {
}