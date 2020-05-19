package lock;

import java.util.concurrent.TimeUnit;

/**
 * @author CBeann
 * @create 2020-04-19 0:39
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "nameA").start();
        new Thread(new HoldLockThread(lockB, lockA), "nameB").start();

    }
}

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }



    @Override
    public void run() {

        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t"+"自己持有："+lockA);
            try { TimeUnit.SECONDS.sleep(2); } catch (Exception e) { e.printStackTrace(); } finally { }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t"+"自己持有："+lockB);


            }

        }

    }
}
