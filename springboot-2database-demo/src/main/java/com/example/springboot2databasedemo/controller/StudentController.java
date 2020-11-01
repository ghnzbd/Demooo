package com.example.springboot2databasedemo.controller;

import com.example.springboot2databasedemo.dao.db1.StudentDao1;
import com.example.springboot2databasedemo.dao.db2.StudentDao2;
import com.example.springboot2databasedemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2020-10-30 14:30
 */
@RestController
public class StudentController {

  // @Autowired private StudentService studentService;

  @Autowired private StudentDao1 studentDao1;
  @Autowired private StudentDao2 studentDao2;

  @GetMapping("/hello")
  public String hello() {
    //Student student = studentDao1.selectByPrimaryKey(1);
    Student student = studentDao2.selectByPrimaryKey(1);
    System.out.println(student);

    return "success";
  }
}
