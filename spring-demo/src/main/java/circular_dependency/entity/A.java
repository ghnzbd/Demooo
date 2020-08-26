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
public class A implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  private B b;

  public A() {
    System.out.println("A 无参构造器。。。");
  }

  public void speak() {
    System.out.println("------AAA---------");
  }

  @Override
  public String toString() {
    return "A toString";
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("'----------A------setApplicationContext---------------");
    this.applicationContext = applicationContext;
  }
}
