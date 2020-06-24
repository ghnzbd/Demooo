package com.example.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author CBeann
 * @create 2020-06-17 23:21
 */
@ApiModel(value = "Student请求", description = "Student请求")
public class Teacher {

    @ApiModelProperty(value = "codee")
    private Integer code;
    @ApiModelProperty(value = "addresss")
    private String address;

    public Teacher() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
