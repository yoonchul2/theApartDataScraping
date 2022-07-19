package com.matching.main.service

import com.matching.main.entity.Martdjy06
import org.springframework.stereotype.Service

@Service
interface BatchService {


    fun insert06(file: String): String

    fun insert08(file: String): String

    fun insert03(file: String): String

    fun insert04(file: String): String

    fun selectBuildMapperTemp(): String

    fun insertBuildMapperTemp(): String

}