package com.example.myauthann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CBeann
 * @create 2020-04-06 23:04
 */
@SpringBootApplication
@RestController
@ServletComponentScan
public class DemooApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemooApplication.class ,args);
    }


}
