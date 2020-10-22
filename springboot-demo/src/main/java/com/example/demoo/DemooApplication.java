package com.example.demoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author CBeann
 * @create 2020-04-06 23:04
 */
@SpringBootApplication
@RestController
public class DemooApplication {
//  @Value("${myname}")
//  private String name;

  public static void main(String[] args) {
    SpringApplication.run(DemooApplication.class, args);
  }

//  @RequestMapping("/name")
//  public String name() {
//
//    return name;
//  }

  @RequestMapping("/hello")
  public String hello(HttpServletRequest servletRequest, HttpSession session) {
    Cookie[] cookies = servletRequest.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        System.out.println(cookie.getName());
        System.out.println(cookie.getValue());
      }
    }

    return "hello world" + new Date();
  }
}
