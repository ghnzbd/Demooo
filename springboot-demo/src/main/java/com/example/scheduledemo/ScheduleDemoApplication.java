package com.example.scheduledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author CBeann
 * @create 2020-03-22 23:56
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ScheduleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDemoApplication.class, args);
    }
}
