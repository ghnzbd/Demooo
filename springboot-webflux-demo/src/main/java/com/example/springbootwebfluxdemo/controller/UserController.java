package com.example.springbootwebfluxdemo.controller;

import com.example.springbootwebfluxdemo.entity.User;
import com.example.springbootwebfluxdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chaird
 * @create 2020-11-17 15:06
 */
@RestController
public class UserController {

  @Autowired private UserService userService;

  // ID查询
  @GetMapping("/user/{id}")
  public Mono<User> getUser(@PathVariable Integer id) {
    return userService.getUserById(id);
  }

  // 查询所有
  // ID查询
  @GetMapping("/users")
  public Flux<User> getAllUser() {
    return userService.getAll();
  }

  // 添加
  @PostMapping("/user")
  public Mono<Void> saveUser(@RequestBody User user) {
    Mono<User> userMono = Mono.just(user);
    return userService.saveUser(userMono);
  }
}
