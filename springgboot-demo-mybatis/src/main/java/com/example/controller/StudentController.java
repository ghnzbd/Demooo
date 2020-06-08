package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-06-04 16:35:45
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

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




}