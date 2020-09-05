package com.example.jsondemo;

import com.example.jsondemo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author CBeann
 * @create 2020-04-06 23:04
 */
@SpringBootApplication
@RestController
public class DemooApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemooApplication.class, args);
    }


    @RequestMapping("/hello")
    public Object jsonObject() {
        Student student = new Student();
        student.setDate(new Date());
        student.setLocalDate(LocalDate.now());
        student.setLocalDateTime(LocalDateTime.now());
        student.setLocalTime(LocalTime.now());

        return student;
    }

}
