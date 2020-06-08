package com.example.controller;

/**
 * @author CBeann
 * @create 2020-06-06 20:53
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @PostMapping("/hello")
    public String hello(String id) {
        return "hello";
    }
}