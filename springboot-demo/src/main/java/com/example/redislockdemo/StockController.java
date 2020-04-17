package com.example.redislockdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author CBeann
 * @create 2020-03-25 0:27
 */
@RestController
public class StockController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/reduce_stock")
    public String reduceStock() {
        //key的名称
        String lockKey = "lock";
        //setnx key value    加锁逻辑
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "1", 30, TimeUnit.SECONDS);
        if (!aBoolean) {//加锁失败
            return "fail";
        }

        //查数据库（redis）中库存数量
        Integer stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
        //判断库存
        if (stock > 0) {
            System.out.println("消费库存成功--->" + stock);
            //更新库存
            stock = stock - 1;
            stringRedisTemplate.opsForValue().set("stock", String.valueOf(stock));
        } else {
            System.out.println("消费库存失败。。。");
        }

        // del key  释放锁逻辑
        stringRedisTemplate.delete(lockKey);
        return "操作完成";
    }
}
