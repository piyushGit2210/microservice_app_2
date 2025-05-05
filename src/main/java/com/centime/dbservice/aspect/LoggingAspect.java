package com.centime.dbservice.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
//@Component
public class LoggingAspect {

    @Before("@annotation(LogMethodParam)")
    public void logMethodParams(JoinPoint joinPoint) {
        System.out.println("Inside logging aspect");
        String method = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        System.out.println("Invoking: " + method + " with params: " + Arrays.toString(args));
    }
}
