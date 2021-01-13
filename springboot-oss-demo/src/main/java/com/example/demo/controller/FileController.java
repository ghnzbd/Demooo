package com.example.demo.controller;

import com.example.demo.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chaird
 * @create 2021-01-12 12:41
 */
@RestController
public class FileController {

  @Autowired private OssUtils ossUtils;

  @PostMapping("/upload")
  public String upload(@RequestParam("file") MultipartFile file, String path) throws Exception {

    if (file == null || file.isEmpty()) {
      return "上传文件为空";
    }

    String upload = ossUtils.upload(file, path);

    return upload;
  }
}
