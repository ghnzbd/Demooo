package com.example.myauthann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author CBeann
 * @create 2020-07-02 10:01
 */
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthInteptor authInteptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 获取http请求拦截器
        registry
                .addInterceptor(authInteptor)
                .addPathPatterns("/**");
    }
}
