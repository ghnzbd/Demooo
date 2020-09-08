package com.example.springbootdemodocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class SpringbootDemoDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoDockerApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        String s = LocalDateTime.now().toString();
        return s;
    }

}
