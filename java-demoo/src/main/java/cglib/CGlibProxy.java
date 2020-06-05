package cglib;



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
     * @param args   目标方法的参数
     * @param proxy  代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {


        if (method.getAnnotation(MyAsyncInterface.class) != null) {
            System.out.println("------6666------------");

            proxy.invokeSuper(object, args);

        } else {
            proxy.invokeSuper(object, args);
        }


        return null;
    }
}