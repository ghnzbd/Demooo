package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dao")//扫描DAO包
public class ReadwriteSepApp {

  public static void main(String[] args) {
    SpringApplication.run(ReadwriteSepApp.class, args);
  }
}
