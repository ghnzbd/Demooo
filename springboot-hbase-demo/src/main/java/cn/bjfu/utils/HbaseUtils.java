package cn.bjfu.utils;

import cn.bjfu.model.Ecodata;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Component
public class HbaseUtils {
    public static Configuration conf;
    public static Admin admin;

    static{
        //使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "Master,Worker1,Worker3,Worker4");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        try {
            Connection connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isTableExist(String tableName) throws MasterNotRunningException,
            ZooKeeperConnectionException, IOException{
        //在HBase中管理、访问表需要先创建HBaseAdmin对象
//Connection connection = ConnectionFactory.createConnection(conf);
//HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin.tableExists(tableName);
    }

    @Test
    public void test()throws Exception{
        TableName[] tableNames = admin.listTableNames();
        for(TableName t:tableNames){
            System.out.println(t);
        }
    }


    public static void insertData (Connection connection,String tableName,String rowkey,String colFamily,String col,String val) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(rowkey.getBytes());
        put.addColumn(colFamily.getBytes(),col.getBytes(),val.getBytes());
        table.put(put);
        table.close();
    }


    @Test
    public void test1(Ecodata ecodata)throws Exception{
        insertData("Ecodatajxyceshi",ecodata);
    }

    public static void createTable(String tableNmae, String[] cols) throws IOException {

        TableName tableName = TableName.valueOf(tableNmae);
        if (admin.tableExists(tableName)) {
            System.out.println("表已存在！");
        } else {
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            for (String col : cols) {
                HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(col);
                hTableDescriptor.addFamily(hColumnDescriptor);
            }
            admin.createTable(hTableDescriptor);
        }
    }


    public static void insertData(String tableName, Ecodata ecodata) throws IOException {
        TableName tablename = TableName.valueOf(tableName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM");
        String dataTimeMinte = sdf.format(ecodata.getDataTime());
        Put put = new Put((ecodata.getStationId()+"-"+dataTimeMinte).getBytes());
        //参数：1.列族名  2.列名  3.值
        put.addColumn("datatype".getBytes(), (ecodata.getDatatypeId()+"").getBytes(), (ecodata.getDataValue()+"").getBytes()) ;
        //HTable table = new HTable(initHbase().getConfiguration(),tablename);已弃用
        Table table = admin.getConnection().getTable(tablename);
        table.put(put);
    }


    public static void main(String[] args) throws Exception {
//        createTable("user_table", new String[] { "information", "contact" });
//        User user = new User("001", "xiaoming", "123456", "man", "20", "13355550021", "1232821@csdn.com");
//        insertData("user_table", user);
//        User user2 = new User("002", "xiaohong", "654321", "female", "18", "18757912212", "214214@csdn.com");
//        insertData("user_table", user2);
          createTable("Ecodatajxyceshi2",new String[]{"datatype"});

    }




}
