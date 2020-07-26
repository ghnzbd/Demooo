package com.example.redissiondemo;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chaird
 * @create 2020-07-24 14:52
 */
@Configuration
public class ConfigBean {

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://47.105.176.145:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
