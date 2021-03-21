package com.example.config;

import com.example.Interceptor.RateLimiterInceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author chaird
 * @create 2020-09-23 16:13
 */
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

  @Autowired private RateLimiterInceptor rateLimiterInceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 获取http请求拦截器
    registry.addInterceptor(rateLimiterInceptor).addPathPatterns("/*");
  }
}
