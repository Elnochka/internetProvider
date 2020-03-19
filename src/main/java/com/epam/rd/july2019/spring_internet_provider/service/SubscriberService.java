package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.web.dto.SubscriberViewDto;


public interface SubscriberService {

    SubscriberViewDto login(String name);
}
