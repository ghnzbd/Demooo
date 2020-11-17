package com.example.reacotr8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chaird
 * @create 2020-11-17 14:20
 */
public class TestReactor {
  public static void main(String[] args) {


    //just方法直接声明
    Flux.just(1,2,3,4).subscribe(System.out::println);
    Mono.just(1).subscribe(System.out::println);

//    Integer[] array={1,2,3,4};
//    Flux.fromArray(array);
//
//    List list = Arrays.asList(array);
//    Flux.fromIterable(list);
//
//    Stream stream = list.stream();
//    Flux.fromStream(stream);
  }
}
