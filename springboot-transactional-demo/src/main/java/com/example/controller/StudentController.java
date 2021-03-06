package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2021-03-05 23:48
 */
@RestController
public class StudentController {

  @Autowired private StudentService studentService;

  @GetMapping("/transactionalNotEffect01")
  public Object getAll() throws Exception {
    studentService.transactionalNotEffect01();
    return 1;
  }

  @GetMapping("/transactionalNotEffect03")
  public Object transactionalNotEffect03() throws Exception {
    studentService.transactionalNotEffect03();
    return 1;
  }

  @GetMapping("/transactionalNotEffect04")
  public Object transactionalNotEffect04() throws Exception {
    studentService.transactionalNotEffect04();
    return 1;
  }
  @GetMapping("/transactionalNotEffect05")
  public Object transactionalNotEffect05() throws Exception {
    studentService.transactionalNotEffect05();
    return "没有测试出来";
  }

}
