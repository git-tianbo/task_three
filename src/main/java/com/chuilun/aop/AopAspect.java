package com.chuilun.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspect {

    private static Logger logger = Logger.getLogger(AopAspect.class);
    //引入日志配置
    /**
     * 定义切点函数
     */
    @Pointcut("execution(* com.chuilun.controller.*.*(..))   ||  execution(* com.chuilun.service.*.*(..))")
    void time() {
    }

    @Around("time()")
    public Object logTimer(ProceedingJoinPoint thisJoinPoint) throws Throwable {

        // 计时并调用目标函数
        long start = System.currentTimeMillis();
        Object result = thisJoinPoint.proceed();
        long time = System.currentTimeMillis() - start;

        logger.info("本次运行消耗时间为：" + time + "ms");

        return result;
    }

}