package com.example.springbootswagger3demo.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

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


    @PostMapping("/hello20210114")
    public String name(@RequestBody Vo vo) {
        System.out.println(vo.getDate());
        return LocalDateTime.now().toString();
    }

}
@Data
class Vo{

    private String time;

    private Date date;

}
