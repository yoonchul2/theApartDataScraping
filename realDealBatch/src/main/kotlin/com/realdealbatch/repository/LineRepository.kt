package com.realdealbatch.repository


import com.realdealbatch.entity.line
import org.springframework.data.jpa.repository.JpaRepository


interface LineRepository  : JpaRepository<line, Long> {
}