package com.epam.rd.july2019.spring_internet_provider.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class ServiceAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.epam.rd.july2019.spring_internet_provider.service..*(..))")
    public void loggingOperation() { }

    @Before("loggingOperation()")
    public void beforeCallAtMethod(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        logger.info("Before method : {} ; args : {}", joinPoint.getSignature().getName(), args);
    }

    @AfterReturning(value = "loggingOperation()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        logger.info("After Returning for the class : {} ; method : {} ; args : {}", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        if (result != null) {
            logger.info("with value : {}", result.toString());
        } else{
            logger.info("with null as return value.");
        }
    }

    @After("loggingOperation()")
    public void afterCallAtMethod(JoinPoint joinPoint) {
        logger.info("After method : {}", joinPoint.getSignature().getName());

    }


}
