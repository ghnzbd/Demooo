package synchronizedd;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author chaird
 * @create 2021-01-18 11:52
 */
// -XX:BiasedLockingStartupDelay=0
public class SynchronizedDemo {
  public static void main(String[] args) {
    Dog dog = new Dog();
    System.out.println("初始状态：");
    System.out.println(ClassLayout.parseInstance(dog).toPrintable());

    new Thread(
            () -> {
              synchronized (dog) {
                System.out.println("");
                try {
                  TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                  e.printStackTrace();
                } finally {
                }
              }
            },
            "t1")
        .start();

    new Thread(
            () -> {
              synchronized (dog) {
                System.out.println("线程2上锁");
                System.out.println(ClassLayout.parseInstance(dog).toPrintable());
                try {
                  TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                  e.printStackTrace();
                } finally {
                }
              }
              System.out.println("线程2释放锁");
              System.out.println(ClassLayout.parseInstance(dog).toPrintable());
            },
            "t2")
        .start();
  }
}

class Dog {
  int age;
}
