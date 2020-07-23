package com.example.myauthann;

import java.lang.annotation.*;

/**
 * @author CBeann
 * @create 2020-07-02 9:57
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
        boolean value() default false;
}
