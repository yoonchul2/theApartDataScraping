package com.bokbuin.main.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.http.codec.HttpMessageWriter
import org.springframework.http.codec.LoggingCodecSupport
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class WebClientConfig {

    @Bean
    fun webClient(): WebClient {

        /* Spring WebFlux 에서는 어플리케이션 메모리 문제를 피하기 위해
         * codec 처리를 위한 in-memory buffer 값이 256KB 로 기본설정 되어 있습니다.
         * 이 제약 때문에 256KB 보다 큰 HTTP 메시지를 처리하려고 하면
         * DataBufferLimitException 에러가 발생하게 되는데 이 케이스를 방지 하기 위해 메모리를 넉넉잡아 설정합니다.
         */
        val exchangeStrategies = ExchangeStrategies.builder()
            .codecs { configurer: ClientCodecConfigurer ->
                configurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 50) // 1)
            }
            .build()

        /* 기본 WebClient 설정에서는 form data 와 header 정보를 로그에서 확인할 수 가 없습니다.
         * 개발 진행 시 Request/Response 정보를 상세히 확인하기 위해서는
         * ExchageStrateges 와 logging level 설정을 통해
         * 로그 확인이 가능하도록 해 주는 것이 좋습니다.*/
        exchangeStrategies
            .messageWriters()
            .stream()
            .filter { obj: HttpMessageWriter<*>? ->
                LoggingCodecSupport::class.java.isInstance(obj)
            }
            .forEach { writer: HttpMessageWriter<*> ->
                (writer as LoggingCodecSupport).isEnableLoggingRequestDetails = true
            }

        return WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .exchangeStrategies(exchangeStrategies)
            .build()
    }
}