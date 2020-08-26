package circular_dependency.entity;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author CBeann
 * @create 2020-01-31 13:07
 */
@Data
public class B implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  public B() {
    System.out.println("B 无参构造器。。。");
  }

  private A a;

  public void speak() {
    System.out.println("------BBB---------");
  }

  @Override
  public String toString() {
    return "B toString";
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("---B------setApplicationContext---");
    this.applicationContext = applicationContext;
  }
}
