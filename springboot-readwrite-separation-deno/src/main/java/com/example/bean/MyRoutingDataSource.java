package com.example.bean;

/**
 * @author chaird
 * @create 2020-12-30 21:37
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
  @Nullable
  @Override
  protected Object determineCurrentLookupKey() {
    return DBContextHolder.get();
  }
}
