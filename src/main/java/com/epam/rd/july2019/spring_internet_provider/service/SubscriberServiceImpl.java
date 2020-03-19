package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.converter.SubscriberConverter;
import com.epam.rd.july2019.spring_internet_provider.dao.SubscriberDao;
import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import com.epam.rd.july2019.spring_internet_provider.validator.SubscriberValidator;
import com.epam.rd.july2019.spring_internet_provider.web.dto.SubscriberViewDto;
import com.epam.rd.july2019.spring_internet_provider.exception.ValidationProjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService, ServiceInterface<Subscriber> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberServiceImpl.class);

    @Autowired
    private SubscriberDao subscriberDaoI;
    @Autowired
    private SubscriberValidator subscriberValidator;
    @Autowired
    private SubscriberConverter subscriberConverter;
    @Autowired
    private SecurityService securityService;

    @Override
    public SubscriberViewDto login(String name) {
        if (!subscriberValidator.validateName(name)){
           throw new ValidationProjectException("Empty name!");
        }
        LOGGER.info("valid" + name);
        Subscriber subscriber = findElementName(name);
        LOGGER.info("sub" + subscriber.getNameSubscriber());
        if (!securityService.isCorrectName(subscriber, name)) {
            throw new ValidationProjectException("Wrong name");
        }
        return subscriberConverter.asSubscriberDto(subscriber);
    }

    @Override
    public List<Subscriber> queryElements() {
        return subscriberDaoI.queryElements();
    }

    @Override
    public Subscriber findElementName(String nameElement) {
        Subscriber obj = subscriberDaoI.findElementName(nameElement);
        return obj;
    }

    @Override
    public Subscriber findElementId(Integer idElement) {
        Subscriber obj = subscriberDaoI.findElementId(idElement);
        return obj;
    }

    @Override
    public void updateElement(Subscriber element) {
        subscriberDaoI.updateElement(element);
    }

    @Override
    public void insertElement(Subscriber element) {
        subscriberDaoI.insertElement(element);
    }

    @Override
    public void deleteElement(Integer idElement) {
        subscriberDaoI.deleteElement(idElement);
    }
}
