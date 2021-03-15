package aop;

/**
 * @author CBeann
 * @create 2020-02-20 16:20
 */
public class MathCalculator {

  public int addMethod(int a, int b) {
      //System.out.println("MathCalculator.....addMethod....");
      //return a + b;
    return addMethodP(a, b);
  }

  private int addMethodP(int a, int b) {
    System.out.println("MathCalculator.....addMethod....");
    return a + b;
  }
}
