package com.realdealbatch.repository


import com.realdealbatch.entity.CarRel
import com.realdealbatch.entity.OccCar
import org.springframework.data.jpa.repository.JpaRepository


interface OccCarRelRepository  : JpaRepository<CarRel, Long> {

}