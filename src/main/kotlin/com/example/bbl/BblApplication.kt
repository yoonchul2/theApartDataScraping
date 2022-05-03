package com.example.bbl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableScheduling

@ServletComponentScan
@EnableScheduling
@SpringBootApplication(scanBasePackages = ["com.example.bbl"])
@EnableAspectJAutoProxy
@EntityScan(basePackages = ["com.example.bbl.entity"])
class BblApplication

fun main(args: Array<String>) {
    runApplication<BblApplication>(*args)
}
