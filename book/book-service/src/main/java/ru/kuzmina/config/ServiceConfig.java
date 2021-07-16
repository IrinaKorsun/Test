package ru.kuzmina.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "ru.kuzmina.dao")
@EntityScan("ru.kuzmina.entity")
public class ServiceConfig {
}
