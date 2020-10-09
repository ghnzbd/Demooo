package initializer;

import web.MyWebInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author chaird
 * @create 2020-10-09 17:29
 */
@HandlesTypes(value = {MyWebInitializer.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
    System.out.println("------------------------------");

    for (Class<?> aClass : c) {
      System.out.println(aClass);
    }
    }
}
