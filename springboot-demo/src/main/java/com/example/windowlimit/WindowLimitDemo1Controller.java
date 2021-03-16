package com.example.windowlimit;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WindowLimitDemo1Controller {

  private static final String USER_PREFIX = "user:";

  private static final Integer LIMIT_NUM = 3;

  // 1小时的毫秒数
  private static final Integer PERIOD = 1 * 60 * 60 * 1000;
  // 1分钟
  private static final Integer PERIOD_WINDOW = 60 * 1000;

  @Autowired private StringRedisTemplate stringRedisTemplate;

  @Autowired private RedisTemplate<String, Object> redisTemplate;

  /** 场景一：1:59分发3条，2:01分发3条成立 线程不安全 */
  @GetMapping("/emailLimit")
  public Object emailLimit(String userName) {

    userName = "zhangsan";

    DateFormat dateTimeInstance = DateFormat.getDateInstance();
    Date date = new Date();
    String format = dateTimeInstance.format(date);

    // 拼接字符串
    String key = USER_PREFIX + format + userName;

    String s = stringRedisTemplate.opsForValue().get(key);

    Integer num = 0;

    if (null != s) {
      num = Integer.parseInt(s);
    }

    if (num < LIMIT_NUM) {
      System.out.println("发送短信");
      // 设置超时
      stringRedisTemplate.opsForValue().set(key, String.valueOf(num + 1), 1, TimeUnit.HOURS);
      return 1;
    } else {
      return 0;
    }
  }

  /** 线程安全 */
  @GetMapping("/emailLimitV2")
  public Object emailLimitV2(String userName) {

    userName = "zhangsan";

    DateFormat dateTimeInstance = DateFormat.getDateInstance();
    Date date = new Date();
    String format = dateTimeInstance.format(date);

    // 拼接字符串
    String key = USER_PREFIX + format + userName;

    // 给key+1，因为redis是单线程的，所以redis那边是线程安全的，这边把结果获取并判断是否大于阈值，也是线程安全的
    Long num = stringRedisTemplate.opsForValue().increment(key, 1);
    // 设置过期时间 一天
    stringRedisTemplate.expire(key, 1 * 24 * 60 * 60 * 1000, TimeUnit.MILLISECONDS);

    if (num < LIMIT_NUM) {
      System.out.println("发送短信");
      // 设置超时
      return 1;
    } else {
      return 0;
    }
  }

  /** 1:59分发3条，2:01分发3条不成立，因为在1:50到2:10这个窗口时间段里发送了6条 下面按照1分钟3条写demo 线不与安全 */
  @GetMapping("/emailWindowLimit")
  public Object emailWindowLimit(String userName) {

    userName = "lisi";
    // 拼接字符串
    String key = USER_PREFIX + userName;
    long current = System.currentTimeMillis();

    // 移除时间窗口之前的行为记录，剩下的都是时间窗口内的
    redisTemplate.opsForZSet().removeRangeByScore(key, 0, current - PERIOD_WINDOW);
    // 获取窗口内的行为数量
    Long zCard = redisTemplate.opsForZSet().zCard(key);

    if (zCard < LIMIT_NUM) {
      System.out.println("send email");

      // 记录行为
      redisTemplate.opsForZSet().add(key, current, current);
      // 设置zset过期时间，避免冷用户持续占用内存
      // 过期时间应该等于时间窗口长度，再多宽限1单位，此处是1毫秒，其实多一秒也行
      redisTemplate.expire(key, PERIOD_WINDOW + 1, TimeUnit.MILLISECONDS);
      return 1;
    }

    return 0;
  }

  /** 1:59分发3条，2:01分发3条不成立，因为在1:50到2:10这个窗口时间段里发送了6条 下面按照1分钟3条写demo 线不与安全 */
  @GetMapping("/emailWindowLimitV2")
  @Deprecated
  public Object emailWindowLimitV2(String userName) {

    userName = "zhangsan";
    // 拼接字符串
    String key = userName;
    //获取当前的时间
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
            + "return res\n"
            + "\n"
            + "\n");
    // defaultRedisScript.setScriptSource(new ResourceScriptSource(new
    // ClassPathResource("redis/demo.lua")));

    List<String> keys = new ArrayList<>();
    keys.add(key);
    Object[] args = new Object[6];
    args[0] = 0;//删除的窗口开始
    args[1] = current-PERIOD_WINDOW;//删除的窗口结束
    args[2] = 60;//设置key的过期时间
    args[3] = LIMIT_NUM;//设置limit
    args[4] = new Date().getTime();//zadd 的元组
    args[5] = new Date().getTime();//zadd 的元组

    Object execute = redisTemplate.execute(defaultRedisScript, keys, args);
    System.out.println(execute);

    return execute;
  }

  @GetMapping("/scriptOK")
  public Object execscript() {

    String script = "local zSetLen = redis.call(\"zcard\", KEYS[1])";

    DefaultRedisScript<Object> defaultRedisScript = new DefaultRedisScript<>();
    defaultRedisScript.setResultType(Object.class);
    defaultRedisScript.setScriptText(script);
    List keys = new ArrayList();
    keys.add("zhangsan");
    String[] args = new String[1];
    args[0] = "2";
    Object execute = redisTemplate.execute(defaultRedisScript, keys, args);

    return execute;
  }
}
