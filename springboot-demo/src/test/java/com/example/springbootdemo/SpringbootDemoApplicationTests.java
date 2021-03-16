package com.example.springbootdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.windowlimit.WindowLimtApp;


@SpringBootTest(classes= WindowLimtApp.class)//制定SpinrgBoot的启动类
@WebAppConfiguration//由于是web项目，所以要模拟Servletontext
class SpringbootDemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired private RedisTemplate<String, Object> redisTemplate;

  @Test
  void contextLoads() {
    String userName = "zhangsan";
    // 拼接字符串
    String key = userName;
    long current = System.currentTimeMillis();

    // 执行一个lua脚本
    String scriptLua = "";

    DefaultRedisScript<Object> defaultRedisScript = new DefaultRedisScript<>();
    defaultRedisScript.setResultType(Object.class);
    defaultRedisScript.setScriptText("--根据score删除数据\n"
            + "redis.call(\"zremrangebyscore\",KEYS[1],ARGV[1],ARGV[2])\n"
            + "\n"
            + "--获取个数\n"
            + "local zSetLen = redis.call(\"zcard\", KEYS[1])\n"
            + "\n"
            + "\n"
            + "\n"
            + "if tonumber(zSetLen) > tonumber(ARGV[4]) then\n"
            + "    return 0\n"
            + "end\n"
            + "--zadd添加数据\n"
            + "local res = redis.call(\"zadd\",KEYS[1], ARGV[5], ARGV[6])\n"
            + "redis.call(\"expire\",KEYS[1],ARGV[3])\n"
            + "return res");
    System.out.println(defaultRedisScript.getScriptAsString());
    // defaultRedisScript.setScriptSource(new ResourceScriptSource(new
    // ClassPathResource("redis/demo.lua")));

    List<String> keys = new ArrayList<>();
    keys.add(key);
    Object[] args = new Object[6];
    args[0] = 0;
    args[1] = 2;
    args[2] = 60;
    args[3] = 4;
    args[4] = new Date().getTime();
    args[5] = new Date().getTime();

    Object execute = redisTemplate.execute(defaultRedisScript, keys, args);
    System.out.println(execute);
  }
}
