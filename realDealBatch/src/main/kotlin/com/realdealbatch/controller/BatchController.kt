package com.realdealbatch.controller

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
@RequestMapping( "test")
class BatchController(
    private var job: Job,
    private var jobLauncher: JobLauncher
) {


    @PostMapping("/batch")
    fun test(){
        jobLauncher.run(
            job, JobParametersBuilder()
                .addString("datetime", LocalDateTime.now().toString())
                .toJobParameters()
        )
    }
}