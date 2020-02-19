package ioc.entity;

import org.springframework.stereotype.Component;

/**
 * @author CBeann
 * @create 2020-01-30 18:42
 */
@Component
public class Student {
    public void speak(){
        System.out.println("------student------");
    }
}
