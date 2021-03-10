package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyStudentService;

/**
 * @author chairongdian <chaidongdian@kuaishou.com>
 * Created on 2021-03-10
 */
@RestController
public class MyStudentController {

@Autowired
    private MyStudentService myStudentService;


//    @GetMapping("/myall")
//    public Object get() {
//        Object select = myStudentService.select();
//        return select;
//    }
}
