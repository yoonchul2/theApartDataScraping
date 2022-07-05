package com.matching.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MatchingApplication

fun main(args: Array<String>) {
    runApplication<MatchingApplication>(*args)
}
