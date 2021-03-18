package com.example.redisthreadsafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lettuce.core.RedisClient;

/**
 * @author chairongdian <chaidongdian@kuaishou.com>
 * Created on 2021-03-18
 */
@RestController
public class RedisThreadSafeController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisClient redisClient;

    @GetMapping("/notThreadSafe")
    public Object notThreadSafe() {

        //步骤1：拼接key
        int foodId = 1;
        String key = "stock:" + foodId;
        //阈值3
        final int LIMIT = 10;



        RedisCallback<Object> objectRedisCallback = new RedisCallback<>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                redisConnection.g


                return null;
            }
        };

        Object execute = stringRedisTemplate.execute(objectRedisCallback);


        //步骤2：获取redis里存的值
        String s = stringRedisTemplate.opsForValue().get(key);
        int num = 0;
        if (!StringUtils.isEmpty(s)) {
            num = Integer.parseInt(s);
        }

        //步骤3：主判断逻辑
        if (num < LIMIT) {
            num++;
            stringRedisTemplate.opsForValue().set(key, String.valueOf(num));
            return 1;
        }

        return 0;


    }
}
