package com.optatum.admin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurerSupport
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync // 1)
class AsyncConfig : AsyncConfigurerSupport() {

    @Bean(name = ["logAsyncExecutor"])
    override fun getAsyncExecutor(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2 // 2)
        executor.maxPoolSize = 10 // 3)
        executor.setQueueCapacity(500) // 4)
        executor.setThreadNamePrefix("log-async-") // 5)
        executor.initialize()
        return executor
    }

    /* Spring Async
     * 1) spring 메소드 비동기 기능을 활성화 한다
     * 2) 기본적으로 실행을 대기하고 있는 Thread 의 갯수
     * 3) 동시에 동작하는 최대 Thread 갯수
     * 4) maxPoolSize 를 초과하는 요청이 발생하는 경우, 우선 Queue 에 저장을 하고, Thread 에 여유가 생길 때 하나씩 꺼내어 처리를 하는데, 이때 큐에 저장할 사이즈를 설정
     * 5) spring 이 생성하는 Thread 의 접두사를 지정한다
     */
}