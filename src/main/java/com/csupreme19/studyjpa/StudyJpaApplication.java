package com.csupreme19.studyjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
public class StudyJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyJpaApplication.class, args);
    }

}
