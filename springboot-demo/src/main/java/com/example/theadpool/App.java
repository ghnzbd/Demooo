package com.example.theadpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author chaird
 * @create 2021-02-22 15:09
 */
@SpringBootApplication
@EnableAsync
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
