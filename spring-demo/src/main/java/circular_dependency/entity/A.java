package circular_dependency.entity;

import lombok.Data;

/**
 * @author CBeann
 * @create 2020-01-31 13:07
 */
@Data
public class A {

    private B b;

    public A() {
        System.out.println("A 无参构造器。。。");
    }

    public void speak() {
        System.out.println("------AAA---------");
    }


}
