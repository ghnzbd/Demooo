package proxydemo.staticproxy;


/**
 * @author chaird
 * @create 2021-01-12 16:07
 */
public class StaticApp {
  public static void main(String[] args) {


      CGlibProxy cGlibProxy = new CGlibProxy();
      TelService proxy = (TelService) cGlibProxy.getProxy(TelService.class);
      proxy.speak();

  }
}
