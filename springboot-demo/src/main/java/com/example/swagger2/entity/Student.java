package com.example.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author CBeann
 * @create 2020-06-16 17:35
 */
@ApiModel(value = "Student请求", description = "Student请求")
public class Student {

    @ApiModelProperty(value = "idd")
    private int id;
    @ApiModelProperty(value = "namee")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }
}
