package com.example.reacotr8;

import java.util.Observable;

/**
 * @author chaird
 * @create 2020-11-17 14:00
 */
public class ObserverDemo extends Observable {
  public static void main(String[] args) {

    ObserverDemo observer = new ObserverDemo();
    // 添加观察者
    observer.addObserver(
        (o, arg) -> {
          System.out.println("发生了变化");
        });

    // 添加观察者
    observer.addObserver(
        (o, arg) -> {
          System.out.println("手动被观察者通知，准备改变");
        });

      observer.setChanged();//数据变化
      observer.notifyObservers();//通知

  }
}
