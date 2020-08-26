package cm;

import java.util.List;

/**
 * @author chaird
 * @create 2020-08-13 10:05
 */
class MyConsumer1 extends Thread {
  List goods;
  //MyProducer1 test;

  public MyConsumer1(List goods) {
    this.goods = goods;
  }

  @Override
  public void run() {
    System.out.println("---MyConsumer1-------run--------");
    synchronized (goods) {
      while (true) {
        System.out.println(Thread.currentThread().getName() + "---start");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if (goods.size() == 1) {
          goods.remove(0);
          System.out.println("消费货物到：" + goods);
          //                    test.interrupt();
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
//          System.out.println("MyConsumer1的notifyAll执行开始");
//          goods.notifyAll();
//          System.out.println("MyConsumer1的notifyAll执行完毕");

          System.out.println("MyConsumer1的notify执行开始");
          goods.notify();
          System.out.println("MyConsumer1的notify执行完毕");

          // 此处改动
          System.out.println("消费唤醒别的");
        } else {
          try {
            System.out.println("消费卸载锁");
            goods.wait();
            System.out.println("消费结束wait");

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
