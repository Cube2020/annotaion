package com.example.annotation.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerLogAspect {

    @Pointcut(value = "@annotation(com.example.annotation.TimerLog)")
    public void timerPointCut() {

    }

    @Around(value = "timerPointCut()")
    public void timerLogAround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(
                "MethodName:" + methodName + ", methodParam:" + parameters.toString() + ",执行时间:" + (endTime - startTime) + "ms");
    }
}
