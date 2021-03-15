package threadpool;

import java.util.concurrent.*;

/**
 * @author CBeann
 * @create 2020-03-20 9:10
 */
public class ThreadPoolDemoo {
  public static void main(String[] args) {
    ExecutorService executorService =
        new ThreadPoolExecutor(
            2,
            5,
            2L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("11");
          }
        };
      executorService.submit(runnable);

  }
}
