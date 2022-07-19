package com.realdealbatch.config

import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit


@Configuration
class RetrofitConfig {
    @Value("http://openapi.molit.go.kr:8081/")
    lateinit var requestUri: String

    @Bean
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Bean
    fun retrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(requestUri)
            .client(client)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }
}