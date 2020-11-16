package com.example.springbootswagger3demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author chaird
 * @create 2020-11-16 18:52
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(String id){
        return id+"\t"+ LocalDateTime.now().toString();
    }
}
