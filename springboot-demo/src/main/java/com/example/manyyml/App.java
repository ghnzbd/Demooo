package com.example.manyyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2020-12-25 0:41
 */
@SpringBootApplication
@RestController
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Value("${name}")
  private String profile;

  @Value("${age}")
  private String age;

  @GetMapping("/profile")
  public String hello() {

    // return profile;
    return profile+age;
  }
}
