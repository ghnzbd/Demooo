package com.example.controller;

/**
 * @author CBeann
 * @create 2020-06-06 20:52
 */

import com.alibaba.fastjson.JSONObject;
import com.example.entity.JsonResult;
import com.example.untils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/auth")
public class AuthorizeController {

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/login")
    public Object login(String loginName,String password) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginName", loginName);
        if ("1".equals(password)) {
            JSONObject jsonObject = jwtHelper.generateToken(claims);

            return JsonResult.success(jsonObject);
        } else {
            return JsonResult.fail("登录帐号或者登录密码错误");
        }
    }
}