package com.example.springbootwebfluxdemo.service.impl;

import com.example.springbootwebfluxdemo.entity.User;
import com.example.springbootwebfluxdemo.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaird
 * @create 2020-11-17 14:57
 */
@Service
public class UserServiceImpl implements UserService {

  // 创建Map对象
  private final Map<Integer, User> users = new HashMap<>();

  public UserServiceImpl() {
    users.put(1, new User("zhangsan", 20, "男"));
    users.put(2, new User("李四", 2, "女"));
  }

  @Override
  public Mono<User> getUserById(Integer id) {

    return Mono.just(users.get(id));
  }

  @Override
  public Flux<User> getAll() {
    return Flux.fromIterable(users.values());
  }

  @Override
  public Mono<Void> saveUser(Mono<User> userMono) {



    return userMono.doOnNext(person->{
        //向map集合里面放值
        int id=users.size()+1;
        users.put(id, person);
    }).thenEmpty(Mono.empty());
  }
}
