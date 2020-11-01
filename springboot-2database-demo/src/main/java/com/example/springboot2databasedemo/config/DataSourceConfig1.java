package com.example.springboot2databasedemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author chaird
 * @create 2020-10-30 14:21
 */
@Configuration
@MapperScan(
    basePackages = "com.example.springboot2databasedemo.dao.db1", // 扫描的dao包
    sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSourceConfig1 {

  @Primary // 表示这个数据源是默认数据源, 这个注解必须要加，因为不加的话spring将分不清楚那个为主数据源（默认数据源）
  @Bean("db1DataSource")
  @ConfigurationProperties(prefix = "spring.datasource.db1") // 读取application.yml中的配置参数映射成为一个对象
  public DataSource getDb1DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean("db1SqlSessionFactory")
  public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource)
      throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    // mapper的xml形式文件位置必须要配置，不然将报错：no statement （这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致）
    bean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db1/*.xml"));//// 扫描的daoXML包
    return bean.getObject();
  }

  @Primary
  @Bean("db1SqlSessionTemplate")
  public SqlSessionTemplate db1SqlSessionTemplate(
      @Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
