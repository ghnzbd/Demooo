package com.example.springbootwebfluxdemo.entity;

import lombok.Data;

/**
 * @author chaird
 * @create 2020-11-17 14:52
 */
@Data
public class User {

    private String name;
    private Integer age;
    private String gender;

    public User(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User() {
    }
}
