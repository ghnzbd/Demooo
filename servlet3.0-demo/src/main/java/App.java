import org.apache.catalina.startup.Tomcat;

/**
 * @author chaird
 * @create 2020-10-09 17:16
 */
public class App {
  public static void main(String[] args) {

    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);

    try {
      tomcat.addWebapp("/", "D:\\others\\temp");
      tomcat.start();
      System.out.println("tomcat start...");
      tomcat.getServer().await();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
