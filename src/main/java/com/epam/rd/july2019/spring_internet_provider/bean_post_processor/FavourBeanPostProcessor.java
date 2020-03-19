package com.epam.rd.july2019.spring_internet_provider.bean_post_processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Component
public class FavourBeanPostProcessor implements BeanPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FavourBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class type = bean.getClass();
        if (type.isAnnotationPresent(Timed.class)) {
            Object proxy = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long beforeExecute = System.currentTimeMillis();
                    Object retVal = method.invoke(bean, args);
                    long afterExecute = System.currentTimeMillis();
                    LOGGER.info("this method was working: " + (afterExecute - beforeExecute) + " ms");
                    return retVal;
                }
            });
            return proxy;
        } else {
            return bean;
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
