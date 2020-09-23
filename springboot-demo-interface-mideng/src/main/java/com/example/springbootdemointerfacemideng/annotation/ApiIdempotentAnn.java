package com.example.springbootdemointerfacemideng.annotation;

import java.lang.annotation.*;

/**
 * @author CBeann
 * @create 2020-07-05 11:57
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiIdempotentAnn {
  boolean value() default true;
}
