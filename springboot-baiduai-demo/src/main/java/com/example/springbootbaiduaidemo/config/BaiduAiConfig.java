package com.example.springbootbaiduaidemo.config;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chaird
 * @create 2020-10-29 19:09
 */
@Configuration
public class BaiduAiConfig {

  /** 你的 App ID */
  @Value("${baidu.ai.APP_ID}")
  private String APP_ID;
  /** 你的 Api Key */
  @Value("${baidu.ai.API_KEY}")
  private String API_KEY;
  /** 你的 Secret Key */
  @Value("${baidu.ai.SECRET_KEY}")
  private String SECRET_KEY;

  @Bean
  public AipImageClassify aipImageClassify() {
    // 初始化一个AipImageClassify
    AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

    // 可选：设置网络连接参数
    client.setConnectionTimeoutInMillis(2000);
    client.setSocketTimeoutInMillis(60000);

    return client;
  }

  //  public static void main(String[] args) {
  //    // 初始化一个AipImageClassify
  //    AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
  //
  //    // 可选：设置网络连接参数
  //    client.setConnectionTimeoutInMillis(2000);
  //    client.setSocketTimeoutInMillis(60000);
  //
  //    // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
  //    //    client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
  //    //    client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理
  //
  //    // 调用接口
  //    String path = "C:\\Users\\25682\\Desktop\\timg.jpg";
  //
  //    // 传入可选参数调用接口
  //    HashMap<String, String> options = new HashMap<String, String>();
  //    options.put("top_num", "3");
  //    options.put("baike_num", "5");
  //
  //    JSONObject res = client.animalDetect(path, options);
  //    System.out.println(res.toString(2));
  //  }
}
