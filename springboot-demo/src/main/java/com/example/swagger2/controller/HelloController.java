package com.example.swagger2.controller;

import com.example.swagger2.entity.Student;
import com.example.swagger2.entity.Teacher;
import org.springframework.web.bind.annotation.*;

/**
 * @author CBeann
 * @create 2020-06-17 23:19
 */
@RestController
public class HelloController {


    @GetMapping("/hello0")
    public String hello0(String id) {
        return "successsuccess";
    }

    @GetMapping("/hello1")
    public String hello1(Student student) {
        return "success";
    }

    @GetMapping("/hello2")
    public String hello2(@RequestBody Student student) {
        return "success";
    }

    @GetMapping("/hello3")
    @ResponseBody
    public String hello3(Student student) {
        return "success";
    }

    @GetMapping("/hello4")
    @ResponseBody
    public String hello4(@RequestBody Student student) {
        return "successsuccess";
    }

    @GetMapping("/hello5")
    @ResponseBody
    public String hello5(Teacher teacher) {
        return "successsuccess";
    }

    @GetMapping("/hello6")
    @ResponseBody
    public String hello6(Student student) {
        return "successsuccess";
    }
}
