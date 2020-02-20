package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author CBeann
 * @create 2020-02-20 16:17
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int aop.MathCalculator.addMethod(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void startLog(){
        System.out.println("start...");
    }

    @After("pointCut()")
    public void endLog(){
        System.out.println("end...");
    }
}
