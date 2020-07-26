package com.example.redissiondemo;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2020-07-24 14:50
 */
@SpringBootApplication
@RestController
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Autowired private RedissonClient redissonClient;

  @Autowired private Redisson redisson;

  @RequestMapping("/hello")
  public String hello() {

    RBucket<Boolean> bucket = redissonClient.getBucket("bucket");
    System.out.println(bucket);
    //null
    System.out.println(bucket.get());
    bucket.set(true);
    if (null == bucket.get()){
      System.out.println("success");
    }else {
      System.out.println("fail");
    }



    return "success";
  }


}
