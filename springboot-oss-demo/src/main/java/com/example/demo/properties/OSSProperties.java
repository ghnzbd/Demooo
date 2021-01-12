package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chaird
 * @create 2021-01-12 12:59
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
@Data
public class OSSProperties {

  private String endpoint;
  private String keyid;
  private String keysecret;
  private String bucketname;


}
