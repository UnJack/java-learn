package mybatis.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @create by jimjian on 2017/11/04 14:18
 **/
public class MyAdvice {

    public void before() throws Throwable {
        System.out.println("before....");
    }

    public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
        System.out.println("around....");
        return joinpoint;
    }
}
