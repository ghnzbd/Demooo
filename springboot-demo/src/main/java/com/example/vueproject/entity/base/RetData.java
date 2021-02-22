package com.example.vueproject.entity.base;

import lombok.Data;

/**
 * @author chaird
 * @create 2021-01-30 19:07
 */
@Data
public class RetData {

  private Integer code;

  private String message;

  private Object data;

  public static RetData SUCCESS(String msg, Object data) {

    RetData retData = new RetData();
    retData.setCode(200);
    retData.setMessage(msg);
    retData.setData(data);
    return retData;
  }

  public static RetData FAIL(String msg, Object data) {

    RetData retData = new RetData();
    retData.setCode(500);
    retData.setMessage(msg);
    retData.setData(data);
    return retData;
  }
}
