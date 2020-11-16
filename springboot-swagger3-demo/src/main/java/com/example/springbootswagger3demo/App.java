package com.example.springbootswagger3demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
