package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;



public interface SecurityService {
    boolean isCorrectName(Subscriber subscriber, String name);
}
