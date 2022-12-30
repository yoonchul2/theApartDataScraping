//package com.realdealbatch.scheduler
//
//import mu.KotlinLogging
////import org.springframework.batch.core.Job
////import org.springframework.batch.core.JobParametersBuilder
//import org.springframework.batch.core.launch.JobLauncher
//import org.springframework.scheduling.annotation.Scheduled
//import org.springframework.stereotype.Component
//import java.time.LocalDateTime
//
//
//@Component
//class BatchScheduler(
//    private var job: Job,
//    private var jobLauncher: JobLauncher
//) {
//
//    private val log = KotlinLogging.logger { }
//
//    // 매일, 9시부터 12시 사이에 10분 간격, 평일
//    @Scheduled(cron = "0 0/10 9-12 * * MON-FRI", zone = "Asia/Seoul")
//    fun exchangeScheduleWeekday() {
//            log.info { "=== [Start] Exchange Scheduler Weekday ===" }
//                jobLauncher.run(
//                    job, JobParametersBuilder()
//                        .addString("datetime", LocalDateTime.now().toString())
//                        .toJobParameters()
//                )
//
//            log.info { "=== [End]   Exchange Scheduler Weekday ===" }
//
//    }
//
//    // 매일, 9시 1회, 주말
//    @Scheduled(cron = "0 0 9 * * SAT,SUN", zone = "Asia/Seoul")
//    fun exchangeScheduleWeekend() {
//        log.info { "=== [Start] Exchange Scheduler Weekend ===" }
//    }
//}