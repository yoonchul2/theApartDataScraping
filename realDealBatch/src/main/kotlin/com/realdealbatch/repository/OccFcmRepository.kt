package com.realdealbatch.repository


import com.realdealbatch.entity.OccFcm
import org.springframework.data.jpa.repository.JpaRepository


interface OccFcmRepository  : JpaRepository<OccFcm, Long> {

}