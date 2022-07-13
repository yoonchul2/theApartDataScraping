package com.realdealbatch.job

import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Configuration
class RealDealBatch(
    private var jobBuilderFactory: JobBuilderFactory,
    private var stepBuilderFactory: StepBuilderFactory) {


    private val log = KotlinLogging.logger { }


    @Value("\${etc.data.file}")
    lateinit var copyFilePath: String

    @Bean
    fun generatePurchaseBatchJob(): Job {
        return jobBuilderFactory.get("generateBatchJob")
            .start(batchFileCopy()) // dateString
            .build()

    }


    // 파일 복사
    @Bean
    @JobScope
    fun batchFileCopy(): Step {
        val purchaseDateString = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyMMdd"))

        log.info {
            "localDate::: ${
                LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyMMdd"))
            }"
        }
        log.info { "localDateTime::: ${LocalDateTime.now()}" }

        return stepBuilderFactory.get("batchFileCopy")
            .tasklet { _: StepContribution?, _: ChunkContext? ->
                val runCatching = runCatching {
                   val test =  Paths.get("$copyFilePath.$purchaseDateString")
                    println("test${test}")
                }
                runCatching.onFailure {
                    it.printStackTrace()
                }

                RepeatStatus.FINISHED
            }.build()
    }
}