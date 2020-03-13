package ioc;

import ioc.entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author CBeann
 * @create 2020-01-30 18:41
 */
@ComponentScan("ioc")
public class App {

    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//        Student bean = (Student)context.getBean("student");
//        bean.speak();


//        Student bean = (Student)context.getBean(Student.class);
//        bean.speak();




        Car bean = (Car)context.getBean(Car.class);
        bean.speak();
//        Car bean = (Car)context.getBean("carFactoryBean");
//        bean.speak();

        System.out.println("--OVER--");

    }
}
