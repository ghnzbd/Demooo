package com.example.theadpool;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author chaird
 * @create 2021-02-22 15:20
 */
@Component
public class HelloListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    System.out.println("listener");
    }

    public HelloListener() {
    System.out.println("init");
    }
}
