package com.realdealbatch.repository


import com.realdealbatch.entity.OccCar
import org.springframework.data.jpa.repository.JpaRepository


interface OccCarRepository  : JpaRepository<OccCar, Long> {

}