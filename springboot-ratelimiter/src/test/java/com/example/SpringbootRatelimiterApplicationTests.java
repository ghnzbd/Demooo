package com.example;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootRatelimiterApplication.class) // 制定SpinrgBoot的启动类
@WebAppConfiguration
class SpringbootRatelimiterApplicationTests {

  @Test
  void contextLoads() {

    RateLimiter rateLimiter = RateLimiter.create(2.0);

    int num = 10;

    for (int i = 0; i < num; i++) {

      boolean r = rateLimiter.tryAcquire();
      System.out.println(System.currentTimeMillis() + ":" + r);
      try {
        TimeUnit.MILLISECONDS.sleep(400);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
      }
    }
  }
}
