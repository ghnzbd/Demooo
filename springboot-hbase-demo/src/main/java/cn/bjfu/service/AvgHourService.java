package cn.bjfu.service;

import cn.bjfu.utils.HbaseUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

/**
 * @author chaird
 * @create 2020-08-21 21:33
 */
@Service
public class AvgHourService {

  public void insertAvgHour() {

    try {
      Connection connection = ConnectionFactory.createConnection(HbaseUtils.conf);
      HTable hTable = (HTable) connection.getTable(TableName.valueOf("Ecodatajxyceshi"));

      Scan scan = new Scan();
      // 使用 HTable 得到 resultcanner 实现类的对象
      ResultScanner resultScanner = hTable.getScanner(scan);
      //      for (Result result : resultScanner) {
      //        Cell[] cells = result.rawCells();
      //        for (Cell cell : cells) {
      //          // 得到 rowkey
      //          System.out.println("行键:" + Bytes.toString(CellUtil.cloneRow(cell)));
      //
      //          // 得到列族
      //          System.out.println("列族" + Bytes.toString(CellUtil.cloneFamily(cell)));
      //          System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
      //          System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
      //        }
      //      }

      Result next = resultScanner.next();
      NavigableMap<byte[], byte[]> familyMap = next.getFamilyMap("datatype".getBytes());

      Set<Map.Entry<byte[], byte[]>> entries = familyMap.entrySet();

      for (Map.Entry<byte[], byte[]> entry : entries) {
        System.out.println((Bytes.toString(entry.getKey())));
        System.out.println((Bytes.toString(entry.getValue())));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
