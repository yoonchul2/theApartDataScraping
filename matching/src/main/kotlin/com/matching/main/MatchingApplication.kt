package com.matching.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableScheduling

@ServletComponentScan
@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
class MatchingApplication

fun main(args: Array<String>) {
    runApplication<MatchingApplication>(*args)
}
