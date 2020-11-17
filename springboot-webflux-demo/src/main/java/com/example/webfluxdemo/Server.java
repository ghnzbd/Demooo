package com.example.webfluxdemo;

import com.example.springbootwebfluxdemo.handler.UserHandler;
import com.example.springbootwebfluxdemo.service.UserService;
import com.example.springbootwebfluxdemo.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

/**
 * @author chaird
 * @create 2020-11-17 16:08
 */
public class Server {


    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.createReacotrServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //创建Router路由

    public RouterFunction<ServerResponse> routingFunction() {
        //创建handler
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);


        //创建路由
        return RouterFunctions
                .route(
                        RequestPredicates
                                .GET("/users/{id}")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::getUserById)
                .andRoute(RequestPredicates
                        .GET("/users")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::getAllUser);


    }

    //创建服务器完成适配

    public void createReacotrServer(){
        //路由和handler适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器完成适配
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();

    }
}
