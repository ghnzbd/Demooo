package proxydemo.staticproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class clz) {
    enhancer.setSuperclass(clz);
    enhancer.setCallback(this);
    return enhancer.create();
  }

  /**
   * @param object 目标类的实例
   * @param method 目标方法的反射对象
   * @param args 目标方法的参数
   * @param methodProxy 代理类的实例
   * @return
   * @throws Throwable
   */
  @Override
  public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {

    System.out.println("------before------------");

    Object o = methodProxy.invokeSuper(object, args);

    System.out.println("------after------------");
    return o;
  }
}
