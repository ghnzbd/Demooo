package wordcount;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//map阶段

//第一个泛型KEYIN 输入数据的key
//第二个泛型VALUEIN 输入数据的value
//第三个泛型KEYOUT 输出数据的key的类型   sa,1   ss,1
//第四个泛型VALUEOUT 输出的数据的value类型
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

    System.out.println("------------------------------->"+Thread.currentThread().getName());

        //获取一行
        String line=value.toString();
        //切分
        String[] words=line.split(" ");
        //循环
        for (String string : words) {
            //SS
            Text k=new Text();
            k.set(string);
            //1
            IntWritable v=new IntWritable();
            v.set(1);
            context.write(k, v);
        }

    }
}