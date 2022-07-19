package com.realdealbatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication(scanBasePackages = ["com.realdealbatch", "com.matching"])
@EnableBatchProcessing
@EntityScan(basePackages = ["com.matching.main.entity","com.matching.main.model"])
class RealDealBatchApplication

fun main(args: Array<String>) {
    runApplication<RealDealBatchApplication>(*args)
}
