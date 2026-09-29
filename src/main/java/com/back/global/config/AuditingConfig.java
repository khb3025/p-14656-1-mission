package com.back.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.OffsetDateTime;
import java.util.Optional;

@Configuration
public class AuditingConfig {
    @Bean
    public DateTimeProvider dateTimeProvider() {
        return ()-> Optional.of(OffsetDateTime.now()); //LocalDateTime과는 다름 (표준시간과 얼마만큼의 차이인가를 기준으로함)
    }
}
