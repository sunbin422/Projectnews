package Aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by sunbin on 2017/8/2.
 */
//增强类
    @Aspect
public class aspectjs {
/*    @Before("execution(*  Aspectj.*.*(..))")
    public void  before(){
        System.out.println("=======before=====");
    }*/

    public void  before(){
        System.out.println("=======before=====");
    }
    public void after(JoinPoint js,Object result){
        System.out.println("=========after=========="+js);
    }

}
