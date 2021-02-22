package com.example.vueproject.entity;

import lombok.Data;

/**
 * @author chaird
 * @create 2021-01-30 19:03
 */
@Data
public class UserInfo {

  private Integer id;
  private String username;
  private String password;
  private String token;
}
