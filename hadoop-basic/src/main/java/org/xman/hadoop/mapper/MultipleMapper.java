package org.xman.hadoop.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2017/3/14.
 */
public class MultipleMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void run(Context context) throws IOException, InterruptedException {
        System.out.println(this.getClass().getName() + ".run invoked.");
        setup(context);
        try {
            while (context.nextKeyValue()) {
                Object key = context.getCurrentKey();
                Text val = context.getCurrentValue();
                StringTokenizer itr = new StringTokenizer(val.toString());
                while (itr.hasMoreTokens()) {
                    word.set(itr.nextToken());
                    context.write(word, one);
                }
            }
        } finally {
            cleanup(context);
        }
    }

    protected void setup(Context context) throws IOException, InterruptedException {
        System.out.println(this.getClass().getName() + ".setup invoked.");
    }

    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        super.map(key, value, context);
        System.out.println(this.getClass().getName() + ".map invoked.");
    }

    protected void cleanup(Context context) throws IOException, InterruptedException {
        System.out.println(this.getClass().getName() + ".cleanup invoked.");
    }
}
