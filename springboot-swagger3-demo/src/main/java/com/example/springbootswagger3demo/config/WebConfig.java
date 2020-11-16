package com.example.springbootswagger3demo.config;

import com.example.springbootswagger3demo.interceptor.LogInterceptor;
import com.example.springbootswagger3demo.interceptor.OtherInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chaird
 * @create 2020-11-16 19:53
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;

  @Autowired OtherInterceptor otherInterceptor;

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册log拦截器
        registry.addInterceptor(logInterceptor)
                // addPathPatterns 用于添加拦截规则 ， 先把所有路径都加入拦截， 再一个个排除
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/swagger-ui/*")
                .excludePathPatterns("/v3/*")
                .excludePathPatterns("/webjars/**");


        // 注册其他拦截器
//        registry.addInterceptor(otherInterceptor)
//                // addPathPatterns 用于添加拦截规则 ， 先把所有路径都加入拦截， 再一个个排除
//                .addPathPatterns("/**");
    }
}
