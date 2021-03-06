package com.example.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * person
 * @author 
 */
@Data
public class Person implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}