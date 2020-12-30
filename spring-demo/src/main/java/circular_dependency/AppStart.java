package circular_dependency;

import circular_dependency.entity.A;
import circular_dependency.entity.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CBeann
 * @create 2020-01-31 13:13
 */
public class AppStart {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("circulardependency.xml");
    A a = (A) context.getBean("a");
    B b = (B) context.getBean("b");

    a.speak();


    System.out.println(a);
  }
}
