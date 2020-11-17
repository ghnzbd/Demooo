package com.example.webfluxdemo;

import com.example.springbootwebfluxdemo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author CBeann
 * @create 2020-11-17 17:52
 */
public class Client {
    public static void main(String[] args) {

        WebClient client=WebClient.create("http://127.0.0.1:63225");

        //根据id查询
        String id = "1";

        User user = client.get().uri("users/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(User.class).block();


        System.out.println("----------------------------------------");
        System.out.println(user);
        System.out.println("----------------------------------------");



        Flux<User> users = client.get().uri("users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(User.class);
        System.out.println("----------------------------------------");

        users.map(stu->stu.getName()).buffer().doOnNext(System.out::println).blockFirst();
        System.out.println("----------------------------------------");


    }
}
