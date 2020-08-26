package cm;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer02 {
  public static void main(String[] args) {
    List list = new LinkedList();
    MyProducer1 producer = new MyProducer1(list);
    MyConsumer1 consumer = new MyConsumer1(list);
    //consumer.test = producer;
    Thread thread3 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  Thread.sleep(2000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                System.out.println("thread3 还没拿到锁-------------------------------------------------");
                synchronized (list) {
                  System.out.println("没想到吧");
                  System.exit(0);
                }
              }
            });
    producer.setName("shengchan");
    consumer.setName("xiaofei");
    producer.start();
    consumer.start();
    thread3.start();
  }
}
