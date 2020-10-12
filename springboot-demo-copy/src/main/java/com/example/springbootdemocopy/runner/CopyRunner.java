package com.example.springbootdemocopy.runner;

import com.example.springbootdemocopy.App;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;

/**
 * @author chaird
 * @create 2020-10-12 20:41
 */
@Component
public class CopyRunner implements CommandLineRunner {
  @Override
  public void run(String... args) throws Exception {

    // window();//window上复制文件
    linux(); // linux上复制文件
  }
  /** 在window系统上把resources下的myfile/secret.txt文件复制到xxx */
  public void linux() throws Exception {

    InputStream inputStream = App.class.getClassLoader().getResourceAsStream("myfile/secret.txt");

    // 获得的系统的根目录
    File fileParent = new File(File.separator);
    /// opt/secret_linux.txt
    File targetFile = new File(fileParent, "/opt/secret_linux.txt");

    if (targetFile.exists()) {
      targetFile.delete();
    }
    targetFile.createNewFile();

    // 使用common-io的工具类即可转换
    FileUtils.copyToFile(inputStream, targetFile);

    // 记得关闭流
    inputStream.close();
  }

  /** 在window系统上把resources下的myfile/secret.txt文件复制到D:\others\temp\temp\secret_win.txt目录下 */
  public void window() throws Exception {

    String sourceFileName = "myfile/secret.txt";

    ClassPathResource classPathResource = new ClassPathResource(sourceFileName);
    InputStream inputStream = classPathResource.getInputStream();

    String targetFileName = "D:\\others\\temp\\temp\\secret_win.txt";

    // 获得的系统的根目录
    File targetFile = new File(targetFileName);

    if (targetFile.exists()) {
      targetFile.delete();
    }
    targetFile.createNewFile();

    // 使用common-io的工具类即可转换
    FileUtils.copyToFile(inputStream, targetFile);

    // 记得关闭流
    inputStream.close();
  }
}
