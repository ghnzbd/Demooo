package com.example.scheduledemo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author CBeann
 * @create 2020-03-22 23:57
 */
@Component
public class TaskComponent {


    /**
     * 任务周期是2秒
     * 任务执行时间是3秒
     */
    @Scheduled(cron = "0/2 * * * * ?  ")//每2秒执行一次
    @Async
    public void sendMessage() {

        System.out.println("定时任务开始执行： " + LocalDateTime.now());

        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("（业务逻辑）发送消息： " + LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
