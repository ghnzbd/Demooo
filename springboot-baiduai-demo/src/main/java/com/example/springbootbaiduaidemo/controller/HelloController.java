package com.example.springbootbaiduaidemo.controller;

import com.example.springbootbaiduaidemo.utils.BaiduAiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2020-10-29 19:40
 */
@RestController
public class HelloController {

  @Autowired private BaiduAiUtils baiduAiUtils;

  @GetMapping("/hello")
  public Object hello() {

    Object o = baiduAiUtils.animalDetect("C:\\Users\\25682\\Desktop\\1.jpg");


    return o.toString();
  }
}
