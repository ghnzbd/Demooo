package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author CBeann
 * @create 2020-03-19 9:40
 */
public class BlockQueueDemoo {
    public static void main(String[] args) throws Exception{
        //BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        blockingQueue.put("hello");
        String take = blockingQueue.take();
        System.out.println(take);


    }
}
