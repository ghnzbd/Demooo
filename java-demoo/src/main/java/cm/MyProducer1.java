package cm;

import java.util.List;

/**
 * @author chaird
 * @create 2020-08-13 10:05
 */
class MyProducer1 extends Thread {
    List goods;

    public MyProducer1(List goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        System.out.println("---MyProducer1-------run--------");
        synchronized (goods) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "---start");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (goods.size() == 0) {
                    goods.add(new Object());
                    System.out.println("生产货物到：" + goods);
                    goods.notify();
                    System.out.println("生产唤醒别的");
                } else {
                    try {
                        System.out.println("生产卸载锁");
                        goods.wait();
                        System.out.println("生产结束wait");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}