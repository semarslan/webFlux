package com.semarslan.webFlux.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.semarslan.webFlux.repository"})
public class MongoConfiguration {

     @Value("examSchedule")
    private String dbName;

}
