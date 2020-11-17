package com.example.reacotr8;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author chaird
 * @create 2020-11-17 10:04
 */
public class ReactorDemo {
  public static void main(String[] args) {


    //断言函数接口
    Predicate<Integer> predicate= i->i>0;
    System.out.println(predicate.test(-9));

    // 消费函数接口
    Consumer<String> consumer = s -> System.out.println(s);
    consumer.accept("hello cbeann");
  }
}
