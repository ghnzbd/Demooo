package proxydemo.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author chaird
 * @create 2021-01-12 15:59
 */
public class DynamicApp {
  public static void main(String[] args) {

    EmailService emailService = new EmailServiceImpl();

    EmailProxy emailProxy = new EmailProxy(emailService);

    EmailService proxyInstance =
        (EmailService)
            Proxy.newProxyInstance(
                    emailProxy.getClass().getClassLoader(),
                    emailService.getClass().getInterfaces(),
                    emailProxy);
    proxyInstance.speak();
  }
}
