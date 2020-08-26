package circular_dependency;

import circular_dependency.entity.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CBeann
 * @create 2020-01-31 13:13
 */
public class AppStart {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("circulardependency.xml");
    //        A a = (A) context.getBean("a");
    //        a.speak();
    //        a.getB().getA().speak();
    A a = (A) context.getBean("a");
    //        B b=(B) context.getBean("b");
    //        C c=(C) context.getBean("c");
      a.getB().speak();
    a.speak();
    //        b.speak();
    //        c.speak();
  }
}
