package com.eg.fintracker.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.financetracker.repository")
@ConditionalOnProperty(name = "spring.mongodb.enabled", havingValue = "true")
public class MongoConfig {
    // MongoDB-specific configuration here
}
