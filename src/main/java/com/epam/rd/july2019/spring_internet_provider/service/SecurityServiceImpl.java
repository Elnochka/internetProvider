package com.epam.rd.july2019.spring_internet_provider.service;


import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import org.springframework.stereotype.Component;

@Component
public class SecurityServiceImpl implements SecurityService {
    @Override
    public boolean isCorrectName(Subscriber subscriber, String name) {
        return subscriber.getNameSubscriber().equals(name);
    }
}
