package com.example.springbootwebfluxdemo;

import com.example.springbootwebfluxdemo.handler.UserHandler;
import com.example.springbootwebfluxdemo.service.UserService;
import com.example.springbootwebfluxdemo.service.impl.UserServiceImpl;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author chaird
 * @create 2020-11-17 16:08
 */
public class Server {

    //创建Router路由

    public RouterFunction<ServerResponse> routingFunction(){
        UserService userService=new UserServiceImpl();
        UserHandler handler=new UserHandler(userService);


retun null;
    }
}
