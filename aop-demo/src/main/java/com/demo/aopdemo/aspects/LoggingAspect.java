package com.demo.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.demo.aopdemo.services..*)")
    public void serviceMethods() {
        //Defining pointcut for loggable methods
    }


    @Pointcut("execution(String com.demo.aopdemo.services..*(..))")
    public void execTimeMethods() {
        //Defining pointcut for  methods with execution time logging
    }

    @Before("execTimeMethods()")
    public void logMethodEnd(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.debug("#######: {}", methodName);
    }


    @After("serviceMethods()")
    public void logMethodStart(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.debug("Start executing method: {}", methodName);
    }

    @Around("serviceMethods()")
    public Object logMethodExecTime(ProceedingJoinPoint jp) throws Throwable {

        final long start = System.currentTimeMillis();
        final Object proceed = jp.proceed();
        final long executionTime = System.currentTimeMillis() - start;
        logger.debug("{} executed in {} ms", jp.getSignature(), executionTime);
        return proceed;

    }

}