package com.rizki.mufrizal.belajar.testing.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.rizki.mufrizal.belajar.testing.domain"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.rizki.mufrizal.belajar.testing.repository"})
@ComponentScan(basePackages = {"com.rizki.mufrizal.belajar.testing"})
public class WebConfig {
    
}
