package com.example.springbootdemoemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/email")
    @ResponseBody
    public String sendEmail() {

        // 发送邮件
        emailService.sendSimpleMail("2568230656@qq.com", "cbeann@163.com", "主题：合并分支邮件", "gitlab合并分支触发钩子程序");

        return "success";
    }

}