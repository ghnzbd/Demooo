package com.example.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author CBeann
 * @create 2020-06-16 17:31
 */
@SpringBootApplication
@EnableSwagger2
public class SwaggerDemo {

    public static void main(String[] args) {

        SpringApplication.run(SwaggerDemo.class, args);



    }


}
