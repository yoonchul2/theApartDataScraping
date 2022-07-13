package com.realdealbatch.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient = WebClient.builder()
        .exchangeStrategies{ builder ->
            builder.codecs {
                it.defaultCodecs().maxInMemorySize(10 * 1024 * 1024) // buffer size 255KB -> 10 MB
            }
        }
        .build()

}