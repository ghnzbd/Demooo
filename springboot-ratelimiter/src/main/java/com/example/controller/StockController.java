package com.example.controller;

import com.example.annotation.ExtRateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

  @GetMapping("/getStock")
  @ExtRateLimiter(permitsPerSecond = 2, timeout = 500)
  public Object getStock() {
    String s = "ok";
    return s;
  }
}
