package proxydemo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chaird
 * @create 2021-01-12 16:00
 */
public class EmailProxy implements InvocationHandler {
  private Object target;

  public EmailProxy(Object subject) {
    this.target = subject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("--------------begin-------------");
    Object invoke = method.invoke(target, args);
    System.out.println("--------------end-------------");
    return invoke;
  }
}
