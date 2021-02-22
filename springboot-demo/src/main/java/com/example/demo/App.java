package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaird
 * @create 2020-12-25 21:28
 */
@SpringBootApplication
@RestController
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/getAll")
  public Object getAll() {
    List<Stduent> stduents = new ArrayList<>();
    stduents.add(new Stduent("zhangsan", 1));
    stduents.add(new Stduent("zhangsan1", 11));
    return stduents;
  }

  @GetMapping("/get/{id}")
  public Object getOne(@PathVariable Integer id) {
    return new Stduent("zhangsan", id);
  }
}

@Data
@AllArgsConstructor
class Stduent {

  private String name;

  private int age;
}
