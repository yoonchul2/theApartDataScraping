package com.bokbuin.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BokbuinApplication

fun main(args: Array<String>) {
    runApplication<BokbuinApplication>(*args)
}
