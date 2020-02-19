package demo;

import org.apache.catalina.startup.Tomcat;

/**
 * @author CBeann
 * @create 2020-01-30 21:55
 */
public class AppStart {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

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
