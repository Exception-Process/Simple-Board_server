package com.example.feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@ConfigurationPropertiesScan
@SpringBootApplication
public class FeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedApplication.class, args);
    }

}
