package circular_dependency.entity;

import lombok.Data;

/**
 * @author CBeann
 * @create 2020-01-31 13:07
 */
@Data
public class B {
    public B() {
        System.out.println("B 无参构造器。。。");
    }

    private A a;

    public void speak() {
        System.out.println("------BBB---------");
    }
}
