package com.matching.main.service

import com.matching.main.entity.Martdjy06
import org.springframework.stereotype.Service

@Service
interface BatchService {

    fun update06(file: String): String

    fun insert06(file: String): String

    fun insert08(file: String): String

    fun update08(file: String): String

}