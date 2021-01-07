package com.example;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Springboot1xAdminDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot1xAdminDemoApplication.class, args);
  }
}
