package com.example.springbootwebfluxdemo.service;

import com.example.springbootwebfluxdemo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chaird
 * @create 2020-11-17 14:54
 */
public interface UserService {

  // 根据ID查询用户
  Mono<User> getUserById(Integer id);

  // 查询所有用户
  Flux<User> getAll();

  // 添加用户
  Mono<Void> saveUser(Mono<User> user);
}
