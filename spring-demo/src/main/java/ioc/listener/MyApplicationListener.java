package ioc.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author chaird
 * @create 2020-10-19 15:00
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    System.out.println("-----------MyApplicationListener-------------");
    
    try { TimeUnit.SECONDS.sleep(3); } catch (Exception e) { e.printStackTrace(); } finally { }
        System.out.println("-----------MyApplicationListener over-------------");
    }
}
