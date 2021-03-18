package com.example.redisthreadsafe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chairongdian <chaidongdian@kuaishou.com>
 * Created on 2021-03-18
 */
@RestController
public class RedisThreadSafeController {

    @Autowired private StringRedisTemplate stringRedisTemplate;

    @Autowired private RedisTemplate<String, Object> redisTemplate;



    @GetMapping("/notThreadSafe")
    public Object notThreadSafe() {

        //步骤1：拼接key
        int foodId = 1;
        String key = "stock:" + foodId;
        //阈值3
        final int LIMIT = 10;




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

    @GetMapping("/threadSafe")
    public Object threadSafe() {

        //步骤1：拼接key
        int foodId = 1;
        String key = "stock:" + foodId;
        //阈值3
        final int LIMIT = 10;


        DefaultRedisScript<Object> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Object.class);
        defaultRedisScript.setScriptText("--根据key判断是否存在\n"
                + "local key = redis.call(\"EXISTS\", KEYS[1])\n"
                + "--存在key\n"
                + "if tonumber(key) == 1 then\n"
                + "    --获取key的值\n"
                + "    local number = redis.call(\"GET\", KEYS[1])\n"
                + "    --key的值小于阈值\n"
                + "    if tonumber(number) < tonumber(ARGV[1]) then\n"
                + "        redis.call(\"incrby\", KEYS[1], ARGV[2])\n"
                + "        return 1\n"
                + "    else\n"
                + "        return 0\n"
                + "    end\n"
                + "\n"
                + "else\n"
                + "    --不存在\n"
                + "    redis.call(\"SET\", KEYS[1], ARGV[2])\n"
                + "    return 1\n"
                + "end");

        List<String> keys = new ArrayList<>();
        keys.add(key);
        Object[] args = new Object[2];
        args[0] = LIMIT;//阈值
        args[1] = 2;//每次加几

        Object execute = redisTemplate.execute(defaultRedisScript, keys, args);
        System.out.println(execute);




        return execute;


    }
}
