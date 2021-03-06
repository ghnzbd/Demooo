package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2021-03-06 17:10
 */
@RestController
public class TransactionalNotEffect02Controller {

  @Autowired private StudentService studentService;

  @GetMapping("/transactionalNotEffect02")
  public Object getAll(){
      studentService.transactionalNotEffect02();
    return 1;
  }
}
