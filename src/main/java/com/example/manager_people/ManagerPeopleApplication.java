package com.example.manager_people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories
public class ManagerPeopleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerPeopleApplication.class, args);
    }
} 