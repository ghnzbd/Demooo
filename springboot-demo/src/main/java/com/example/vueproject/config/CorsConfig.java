package com.example.vueproject.config;

/**
 * @author chaird
 * @create 2021-01-30 19:33
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration

public class CorsConfig extends WebMvcConfigurerAdapter {



  @Override

  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/**")

      .allowedOrigins("*")

      .allowCredentials(true)

      .allowedMethods("GET", "POST", "DELETE", "PUT")

      .maxAge(3600);

  }



}
