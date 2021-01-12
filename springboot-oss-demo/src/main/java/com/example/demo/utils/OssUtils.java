package com.example.demo.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.demo.properties.OSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

/**
 * @author chaird
 * @create 2021-01-12 13:02
 */
@Component
public class OssUtils {

  @Autowired private OSSProperties ossProperties;

  public String upload(MultipartFile file, String path) throws Exception {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = ossProperties.getEndpoint();
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    String accessKeyId = ossProperties.getKeyid();
    String accessKeySecret = ossProperties.getKeysecret();
    String bucketName = ossProperties.getBucketname();
    // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
    String objectName = file.getOriginalFilename();

    if (!StringUtils.isEmpty(path)) {
      objectName = path + "/" + objectName;
    }

    // 创建OSSClient实例。
    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
    ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(file.getBytes()));

    // 关闭OSSClient。
    ossClient.shutdown();

    return generateFileUrl(objectName);
  }

  private String generateFileUrl(String fileName) {
    if (StringUtils.isEmpty(fileName)) {
      return null;
    } else {
      return "http://"
          + ossProperties.getBucketname()
          + "."
          + ossProperties.getEndpoint()
          + "/"
          + fileName;
    }
  }
}
