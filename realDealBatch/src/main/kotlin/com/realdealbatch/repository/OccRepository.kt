package com.realdealbatch.repository


import com.realdealbatch.entity.Occ
import org.springframework.data.jpa.repository.JpaRepository


interface OccRepository  : JpaRepository<Occ, Long> {

    fun findOccByHoSeq(id : Long) : Occ
}