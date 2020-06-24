package com.example.springbootdemoemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootDemoEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoEmailApplication.class, args);
    }

}
