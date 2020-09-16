package wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.util.Random;

public class WordcountDriver {

  public static void main(String[] args) throws Exception {

    // 输入路径（处理E:\temp\input下的***文件）
    String inputPath = "F:\\temp\\others\\temp\\input";
    inputPath = "D:\\others\\temp\\input";
    // 输出路径（output文件夹不能存在，否则报错）
    String outputPath = "F:\\temp\\others\\temp\\output";
    outputPath = "D:\\others\\temp\\output" + new Random().nextInt(1000000);

    Configuration conf = new Configuration();

    // 1 获取Job对象
    Job job = Job.getInstance(conf);

    // 2 设置jar存储位置
    job.setJarByClass(WordcountDriver.class);

    // 3 关联Map和Reduce类
    job.setMapperClass(WordCountMapper.class);
    job.setReducerClass(WordCountReducer.class);

    // 4 设置Mapper阶段输出数据的key和value类型
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);

    // 5 设置最终数据输出的key和value类型
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    // 6 设置输入路径和输出路径
    FileInputFormat.setInputPaths(job, new Path(inputPath));

    FileOutputFormat.setOutputPath(job, new Path(outputPath));

    // 7 提交job
    // job.submit();
    job.waitForCompletion(true);

    //System.in.read();

    System.out.println("-------OVER-----------");
  }
}
