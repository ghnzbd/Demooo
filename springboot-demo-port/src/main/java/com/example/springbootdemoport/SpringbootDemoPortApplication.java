package com.example.springbootdemoport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class SpringbootDemoPortApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootDemoPortApplication.class, args);
  }

  @Value("${server.port}")
  private String port;

  @GetMapping("/hello")
  public String hello() {
    LocalDateTime now = LocalDateTime.now();
    String msg = "port:" + port + "\n" + now.toString();
    return msg;
  }

  @GetMapping("/test")
  public String test(HttpServletRequest request) {

    System.out.println("request.getRemoteAddr()--->  " + request.getRemoteAddr());
    System.out.println(
        "request.getRequestURL().toString()--->  " + request.getRequestURL().toString());

    return "success";
  }
}
