package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.RateLimiter;


@Service
public class StockService {


    @Autowired
    private GuavaRateLimiterService guavaRateLimiterService;


    /**
     * 每秒钟只发出2个令牌，拿到令牌的请求才可以进入下一个业务
     */
    private RateLimiter seckillRateLimiter = RateLimiter.create(2);

    public boolean tryAcquireSeckill() {
        return seckillRateLimiter.tryAcquire();
    }


    public String executeSeckill() {
        // 验证是否被限流器限制，如果没有，则继续往下执行业务
        if(guavaRateLimiterService.tryAcquireSeckill()){
            return "哈哈哈，你没有限制住我！啦啦啦啦！";
        }else {
            //被限流器限制
            return "呜呜呜，竟然限制我！！！";
        }
    }
}
