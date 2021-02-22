package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CBeann
 * @create 2020-02-20 16:29
 */
public class Srart {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(IOCConfig.class);
    MathCalculator bean = (MathCalculator) context.getBean("mathCalculator");
    int i = bean.addMethod(1, 2);
    System.out.println(i);
  }
}
