package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CBeann
 * @create 2020-02-21 0:35
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            System.out.println("----------logic--------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }


}
