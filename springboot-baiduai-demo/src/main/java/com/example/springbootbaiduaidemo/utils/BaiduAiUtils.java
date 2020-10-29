package com.example.springbootbaiduaidemo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author chaird
 * @create 2020-10-29 19:36
 */
@Component
public class BaiduAiUtils {

  @Autowired private AipImageClassify aipImageClassify;

  public Object animalDetect(String path) {
    // 传入可选参数调用接口
    HashMap<String, String> options = new HashMap<String, String>(2);
    options.put("top_num", "3");
    options.put("baike_num", "5");

    JSONObject res = aipImageClassify.animalDetect(path, options);
    //System.out.println(res.toString(2));
    return res;
  }
}
