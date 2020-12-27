package com.example.runListenerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Properties;

/**
 * @author chaird
 * @create 2020-10-16 19:56
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

  private SpringApplication application;
  private String[] args;

  public MySpringApplicationRunListener(SpringApplication application, String[] args) {
    this.application = application;
    this.args = args;
  }

  @Override
  public void starting() {

    System.out.println("------------");
  }

  @Override
  public void environmentPrepared(ConfigurableEnvironment environment) {

      //配置文件读取到程序中，思路需要自己自己将本地文件读取到程序中，然后放到SpringBoot容器中
    Properties properties = new Properties();
    try {
      //读取我们的my.properties文件
        properties.load(this.getClass().getClassLoader().getResourceAsStream("my.properties"));
        //读取名称my
        PropertySource propertySource=new PropertiesPropertySource("myname", properties);

        //将资源放入ioc中
        MutablePropertySources propertySources = environment.getPropertySources();
      propertySources.addLast(propertySource);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextPrepared(ConfigurableApplicationContext context) {}

  @Override
  public void contextLoaded(ConfigurableApplicationContext context) {}

  @Override
  public void started(ConfigurableApplicationContext context) {}

  @Override
  public void running(ConfigurableApplicationContext context) {}

  @Override
  public void failed(ConfigurableApplicationContext context, Throwable exception) {}
}
