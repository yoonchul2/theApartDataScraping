package com.realdealbatch.repository


import com.realdealbatch.entity.OccFm
import org.springframework.data.jpa.repository.JpaRepository


interface OccFmRepository  : JpaRepository<OccFm, Long> {
        fun findOccFmByOSeqAndName(id:Long,name: String) : OccFm?
}