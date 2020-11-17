import java.util.stream.IntStream;

/**
 * @author CBeann
 * @create 2020-02-20 2:49 thread.interrupt(); thread.isInterrupted();
 *     Thread.currentThread().isInterrupted();
 */
public class Start {

  public static void main(String[] args) throws Exception {

    int[] nums = { 1, 2, 3 };
    int sum2 = IntStream.of(nums).parallel().sum();
    System.out.println("结果为：" + sum2);
  }
}
