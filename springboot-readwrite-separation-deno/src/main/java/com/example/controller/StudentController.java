package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2020-12-30 21:40
 */
@RestController
public class StudentController {

  @Autowired private StudentService studentService;

  @GetMapping("/getAllMaster")
  public Object getAllMaster() {
    return studentService.getAllMaster();
  }

  @GetMapping("/getAllSlave")
  public Object getAllSlave() {
    return studentService.getAllSlave();
  }

  @PostMapping("/save")
  public Object save(@RequestBody Student student) {
    studentService.add(student);
    return "success";
  }
}
