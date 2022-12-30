package com.realdealbatch.repository


import com.realdealbatch.entity.Dong
import org.springframework.data.jpa.repository.JpaRepository


interface DongRepository  : JpaRepository<Dong, Long> {

    fun findDongByDongNum(dongNum :String) : Dong
}