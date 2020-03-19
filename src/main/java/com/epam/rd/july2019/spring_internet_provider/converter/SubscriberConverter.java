package com.epam.rd.july2019.spring_internet_provider.converter;


import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import com.epam.rd.july2019.spring_internet_provider.web.dto.SubscriberViewDto;
import org.springframework.stereotype.Component;

@Component
public class SubscriberConverter {

    public SubscriberViewDto asSubscriberDto(Subscriber subscriber) {

        SubscriberViewDto dto = new SubscriberViewDto();
        dto.setName(subscriber.getNameSubscriber());
        dto.setId(subscriber.getIdSubscriber());

        return dto;
    }
}
