package ioc.beanFactoryPostProcessor;

import ioc.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author chaird
 * @create 2020-10-22 19:01
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

  @Override
  public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
      throws BeansException {
    if (beanName.equals("student")) {
      return new Student();
    }
    return null;
  }

  @Override
  public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
    return false;
  }
}
