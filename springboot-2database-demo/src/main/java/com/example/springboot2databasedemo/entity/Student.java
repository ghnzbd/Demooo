package com.example.springboot2databasedemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer studentid;

    private Integer classid;

    private Integer score;

    private static final long serialVersionUID = 1L;
}