package com.example.springbootwebfluxdemo.handler;

import com.example.springbootwebfluxdemo.entity.User;
import com.example.springbootwebfluxdemo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author chaird
 * @create 2020-11-17 15:50
 */
public class UserHandler {

  private final UserService userService;

  public UserHandler(UserService userService){
    this.userService = userService;
  }

  //根据ID查询
    public Mono<ServerResponse> getUserById(ServerRequest request){
    //获取Id
      Integer id=Integer.parseInt(request.pathVariable("id"));
    // 空值处理
    Mono<ServerResponse> noFound = ServerResponse.notFound().build();

      //调用service
      Mono<User> userMono = this.userService.getUserById(id);
      //把userMono进行转换
      return userMono.flatMap
              (person->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person)))
              .switchIfEmpty(noFound);
    }


  //查询所有
  public Mono<ServerResponse> getAllUser(ServerRequest request){
    // 空值处理
    Mono<ServerResponse> noFound = ServerResponse.notFound().build();

    //调用service
    Flux<User> users = this.userService.getAll();
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
  }


  //添加
  public Mono<ServerResponse>SaveUser(ServerRequest request){

    Mono<User> userMono = request.bodyToMono(User.class);

    //调用service
    return ServerResponse.ok().build(this.userService.saveUser(userMono));
  }
}
