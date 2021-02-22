package ioc.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chaird
 * @create 2021-02-20 15:26
 */
@Data
@Component
public class CarGroup {

  @Autowired private Car car;

  public void speak(){
    System.out.println("carGroup");
    car.speak();
  }
}
