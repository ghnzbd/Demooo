package ioc;

import ioc.select.MySelector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author CBeann
 * @create 2020-01-30 18:41
 */
@ComponentScan("ioc")
@Import({MySelector.class})
public class AppMyulticasterDemo {

  public static void main(String[] args) throws Exception {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppMyulticasterDemo.class);

    System.out.println("--OVER--");
  }
}
