package com.centime.dbservice;

import com.centime.dbservice.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ApConfig {

    @Bean
    LoggingAspect messageAspect() {
        return new LoggingAspect();
    }
}
