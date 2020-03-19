package com.epam.rd.july2019.spring_internet_provider.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.epam.rd.july2019.spring_internet_provider.aspects.NameTime)")
    public void callNameTimeAnnotation() { }

    @Around("callNameTimeAnnotation()")
    public Object aroundCallAt(ProceedingJoinPoint pjp) throws Throwable{

        long beforeExecute = System.currentTimeMillis();
        Object result = pjp.proceed();
        long timeOfWork = System.currentTimeMillis() - beforeExecute;
        logger.info("Annotation Around the method : {} , work : {} ms, in the class : {}", pjp.getSignature().getName(), timeOfWork , pjp.getTarget().getClass().getSimpleName());
        return result;
    }
}