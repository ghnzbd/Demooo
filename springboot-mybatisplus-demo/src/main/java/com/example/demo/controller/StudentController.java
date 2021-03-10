package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.impl.StudentServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vicente
 * @since 2021-03-10
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/all")
    public Object getAll(){
        List<Student> list = studentService.list();
        return list;
    }

}
