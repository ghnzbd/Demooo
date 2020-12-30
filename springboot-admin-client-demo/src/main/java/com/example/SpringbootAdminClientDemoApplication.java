package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class SpringbootAdminClientDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootAdminClientDemoApplication.class, args);
  }

  @GetMapping("/hello")
  public Object hello(){

    return LocalDateTime.now().toString();
  }
}
