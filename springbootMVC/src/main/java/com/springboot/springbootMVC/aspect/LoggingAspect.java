package com.springboot.springbootMVC.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.springboot.springbootMVC.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.springboot.springbootMVC.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.springboot.springbootMVC.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void afterReturning(JoinPoint theJoinPoint){

        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before calling method: " + theMethod);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArgs: args) {
            myLogger.info("=====>> arguments: " + tempArgs);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning from method: " + theMethod);

        myLogger.info("=====>> result: " + theResult);
    }



}
