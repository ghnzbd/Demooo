package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CBeann
 * @create 2020-02-21 0:35
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {


        ReentrantLock reentrantLock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("----------t1 logic--------------");
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("----------t2 logic--------------");
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        },"t2");
        t2.start();
        reentrantLock.lock();
        try {
            System.out.println("----------main logic--------------");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }


}
