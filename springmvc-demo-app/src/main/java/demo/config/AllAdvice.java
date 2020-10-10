package demo.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chaird
 * @create 2020-10-09 19:43
 */
//@ControllerAdvice
public class AllAdvice {

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public String exception(Exception e) {
    System.out.println("1111111111111");
    return "111111111111！";
  }
}
