package com.example.demo.config;

import com.example.demo.properties.OSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author chaird
 * @create 2021-01-12 12:56
 */
@Configuration
public class OssConfig {

  @Autowired private OSSProperties ossProperties;




}
