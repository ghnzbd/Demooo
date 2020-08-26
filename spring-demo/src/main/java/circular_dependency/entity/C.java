package circular_dependency.entity;

import lombok.Data;

/**
 * @author CBeann
 * @create 2020-01-31 23:15
 */
@Data
public class C {

  public C() {
    System.out.println("C 无参构造器。。。");
  }

  private A a;

  public void speak() {
    System.out.println("------CCC---------");
  }
}
