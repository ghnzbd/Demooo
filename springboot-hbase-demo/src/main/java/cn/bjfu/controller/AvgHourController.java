package cn.bjfu.controller;

import cn.bjfu.service.AvgHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaird
 * @create 2020-08-21 21:34
 */
@RestController
public class AvgHourController {

  @Autowired private AvgHourService avgHourService;

  @GetMapping("/hello")
  public String hello() {
    avgHourService.insertAvgHour();
    return "success";
  }
}
