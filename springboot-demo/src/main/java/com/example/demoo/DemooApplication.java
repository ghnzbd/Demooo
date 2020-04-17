package com.example.demoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author CBeann
 * @create 2020-04-06 23:04
 */
@SpringBootApplication
@RestController
public class DemooApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemooApplication.class ,args);
    }


    @RequestMapping("/hello")
    public String hello(){
        return "hello world"+ new Date();
    }
}
