package com.example.springbootseckilldemo;

import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2021-02-25 8:49
 */
@RestController
public class HelloController {

  @Autowired private StringRedisTemplate stringRedisTemplate;

  @Autowired private RedissonClient redissonClient;


  @GetMapping("/hello")
  public Object hello() {
//    String s = stringRedisTemplate.opsForValue().get("stock");
//    return s;

    RSemaphore semaphore = redissonClient.getSemaphore("stock");
    boolean b = semaphore.tryAcquire();
    //查数据库（redis）中库存数量
    Integer stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

    if (b){
      System.out.println("抢购成功"+stock);
    }else {
      System.out.println("抢购失败");
    }

    return 1;

  }
}
