package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StockController {

    @Autowired
    private StockService stockService;


    @GetMapping("/hello")
    public Object dologic(){

        String s = stockService.executeSeckill();
        return s;


    }
}
