package cn.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sunbin on 2017/7/24.
 */
public class LoggerBefore implements MethodBeforeAdvice{

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("33333333");
    }
}
