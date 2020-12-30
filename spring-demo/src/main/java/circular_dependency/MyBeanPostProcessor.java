package circular_dependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author chaird
 * @create 2020-12-27 20:36
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

//    if (beanName.equals("a")) {
//      return new A();
//    }
    return bean;
  }
}
