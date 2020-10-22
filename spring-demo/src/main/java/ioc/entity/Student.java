package ioc.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author CBeann
 * @create 2020-01-30 18:42
 */
@Component
public class Student implements BeanFactoryAware, ApplicationContextAware {




  public Student() {
    System.out.println("Student 无参构造器");
  }

  public void speak() {
    System.out.println("------student------");
  }

  private ApplicationContext applicationContext;

  public Object getapplicationContext() {
    return applicationContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
    System.out.println("Student......ApplicationContextAware");
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    System.out.println("Student......setBeanFactory");
  }
}
