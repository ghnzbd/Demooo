package com.example.springboot2databasedemo.service;

import com.example.springboot2databasedemo.dao.db1.StudentDao1;
import com.example.springboot2databasedemo.dao.db2.StudentDao2;
import com.example.springboot2databasedemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chaird
 * @create 2020-10-30 14:28
 */
//@Service
public class StudentService {

  @Autowired private StudentDao1 studentDaoDb1;
  @Autowired private StudentDao2 studentDaoDb2;

  public void transform(int id) {
    Student student = studentDaoDb1.selectByPrimaryKey(1);
    studentDaoDb2.insert(student);
    System.out.println("0ver");
  }
}
