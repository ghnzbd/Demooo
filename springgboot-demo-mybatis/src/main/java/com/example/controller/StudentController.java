package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-06-04 16:35:45
 */
@RestController
@RequestMapping("student")
public class StudentController {
  /** 服务对象 */
  @Resource private StudentService studentService;

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("selectOne")
  public String selectOne(Integer id) {
    System.out.println("-------------");
    Student student = this.studentService.queryById(id);
    System.out.println(student);
    return "success";
  }

  @GetMapping("hello")
  public String hello() {
    System.out.println("-------------");
    return "hello";
  }

  @GetMapping("insert")
  public String insert() {
    System.out.println("-------------");
    Student student = new Student();
    student.setId(123);
    student.setName("123");
    student.setLocaldatetime(new Date());
    studentService.insert(student);
    System.out.println(student);

    return "hello";
  }
}
