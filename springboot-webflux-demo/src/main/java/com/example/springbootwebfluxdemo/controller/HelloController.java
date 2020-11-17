package com.example.springbootwebfluxdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author chaird
 * @create 2020-11-17 9:58
 */
@RestController
public class HelloController {

    @GetMapping("/1")
    public String get1(){
    return LocalDateTime.now().toString();
    }

    @GetMapping("/2")
    public Mono<String> get2(){
        return Mono.just(LocalDateTime.now().toString());
    }

    @GetMapping(value = "/3",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> get3(){

        Flux<String> result=Flux.fromStream(IntStream.range(1, 5).mapToObj(i->{
            try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); } finally { }
            return "flux data "+i;
        }));
        return result;
    }




}
