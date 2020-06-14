package wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
//KETIN KEYOUT map阶段输出的key和value
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum=0;

        //累加求和
        for (IntWritable value : values) {
            sum+=value.get();
        }

        IntWritable v=new IntWritable();
        v.set(sum);
        context.write(key, v);

    }

}