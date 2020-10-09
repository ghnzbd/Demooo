package web.impl;

import web.MyWebInitializer;

/**
 * @author chaird
 * @create 2020-10-09 18:16
 */
public class MySpringInitalizer implements MyWebInitializer {
    @Override
    public void speak() {
    System.out.println("MySpringInitalizer----------------");
    }
}
