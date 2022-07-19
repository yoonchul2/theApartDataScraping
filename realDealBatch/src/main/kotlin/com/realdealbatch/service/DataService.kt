package com.realdealbatch.service

import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import retrofit2.Retrofit


@Service
class DataService(
    private val retrofit: Retrofit
    ) {



    fun recivePublicData(){
        println(mutableListOf("11140","11110"))
        val response = runBlocking {
            retrofit.create(ApartInterface::class.java)
                .getRestDeInfo(DEAL_YMD = "201512")
                .execute()
                .body()

        }

        println("response?.body?.items;${response?.body?.items?.size}")

    }

}