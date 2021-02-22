package com.example.theadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author chaird
 * @create 2021-02-22 15:11
 */
@Service
public class EmailService {

  @Async
  public void sendEmail() {
    System.out.println("---start--");
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }

    System.out.println("---end--");
  }
}
