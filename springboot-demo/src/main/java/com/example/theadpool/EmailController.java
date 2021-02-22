package com.example.theadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2021-02-22 15:11
 */
@RestController
public class EmailController {

  @Autowired private EmailService emailService;

  @GetMapping("/hello")
  public Object hello() {
    emailService.sendEmail();
    return 1;
  }
}
