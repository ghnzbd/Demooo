package threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author CBeann
 * @create 2020-03-20 9:10
 */
public class ThreadPoolDemoo {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(5);
        //Executor executor = Executors.newCachedThreadPool();
        //Executor executor = Executors.newScheduledThreadPool(10);

    }
}
