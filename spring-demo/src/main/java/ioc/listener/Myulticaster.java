package ioc.listener;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * @author chaird
 * @create 2021-02-22 15:46
 */
@Component(value = "applicationEventMulticaster")
public class Myulticaster extends SimpleApplicationEventMulticaster {
  public Myulticaster() {
    setTaskExecutor(Executors.newSingleThreadExecutor());
  }
}
