package ioc.autoward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chaird
 * @create 2021-03-04 18:24
 */
@Component
public class Aa {

  @Autowired
  private Bb bb;

  public void speak(){
    System.out.println("speak AA");
    bb.speak();
  }


  public Bb getBb() {
    return bb;
  }

  public void setBb(Bb bb) {
    this.bb = bb;
  }
}
