package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-06-04 16:35:45
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -66058013456380609L;
    
    private Integer id;
    
    private String name;
    
    private Date localdatetime;






}