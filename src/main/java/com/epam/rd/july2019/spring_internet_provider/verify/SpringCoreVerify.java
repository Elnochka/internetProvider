package com.epam.rd.july2019.spring_internet_provider.verify;

import com.epam.rd.july2019.spring_internet_provider.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreVerify {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WebConfig.class);
        context.refresh();

    }


}
