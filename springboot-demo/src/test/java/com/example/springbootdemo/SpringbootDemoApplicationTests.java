package com.example.springbootdemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.windowlimit.WindowLimtApp;


@SpringBootTest(classes = WindowLimtApp.class)//制定SpinrgBoot的启动类
@WebAppConfiguration
        //由于是web项目，所以要模拟Servletontext
class SpringbootDemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
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
    }
}
