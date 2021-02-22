package com.example.vueproject.controller;

import com.example.vueproject.entity.UserInfo;
import com.example.vueproject.entity.base.RetData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chaird
 * @create 2021-01-30 19:05
 */
@RestController
public class LoginController {

  @PostMapping("/user/login")
  public Object login(@RequestBody UserInfo userInfo) {
    System.out.println("--------------------------------");

    if ("admin".equals(userInfo.getUsername()) && "123456".equals(userInfo.getPassword())) {

      userInfo.setId(1);
      userInfo.setToken(UUID.randomUUID().toString().substring(0, 8));
      return RetData.SUCCESS("登录成功", userInfo);
    }

    return RetData.FAIL("用户名或者密码错误", null);
  }
}
