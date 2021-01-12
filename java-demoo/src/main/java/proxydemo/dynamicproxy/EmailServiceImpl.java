package proxydemo.dynamicproxy;

/**
 * @author chaird
 * @create 2021-01-12 15:58
 */
public class EmailServiceImpl implements EmailService {
  @Override
  public void speak() {
    System.out.println("--EmailServiceImpl--");
  }
}
