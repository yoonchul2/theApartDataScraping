package com.realdealbatch.repository


import com.realdealbatch.entity.OccCar
import com.realdealbatch.entity.OccExpenses
import org.springframework.data.jpa.repository.JpaRepository


interface OccExRepository  : JpaRepository<OccExpenses, Long> {

}