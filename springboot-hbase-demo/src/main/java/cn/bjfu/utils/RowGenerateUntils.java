package cn.bjfu.utils;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chaird
 * @create 2020-08-21 21:49
 */
public class RowGenerateUntils {

  /**
   * 根据站点和时间段生成hbasezhongrowKay:1-2017-26-06 09:12
   *
   * @param stationId 站点ID
   * @param startTime 开始时间(时间左闭右开)
   * @param endTime 结束时间(时间左闭右开)
   * @return rowKey集合
   */
  public static List<String> createRowKey(Integer stationId, Date startTime, Date endTime) {

    List<String> result = new ArrayList<>();
    String format;

    while (startTime.getTime() < endTime.getTime()) {
      format = DateUtil.format(startTime, "yyyy-MM-dd HH:mm");
      // 拼接rowkey
      result.add(stationId + "-" + format);
      // startTime+1分钟
      startTime = DateUtil.offsetMinute(startTime, 1);
    }

    return result;
  }

  public static void main(String[] args) {
    // 当前时间
    Date date = new Date();
    Date dateTime = DateUtil.offsetMinute(date, 60);

    List<String> rowKey = RowGenerateUntils.createRowKey(1, date, dateTime);
    rowKey.forEach(System.out::println);
  }
}
