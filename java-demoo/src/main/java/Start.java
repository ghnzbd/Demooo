import java.util.concurrent.*;

/**
 * @author CBeann
 * @create 2020-02-20 2:49
 */
public class Start {

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

    for (int i = 0; i < 5; i++) {
      Runnable runnable =
          new Runnable() {
            @Override
            public void run() {


            }
          };

      executorService.submit(runnable);
    }
  }
}
