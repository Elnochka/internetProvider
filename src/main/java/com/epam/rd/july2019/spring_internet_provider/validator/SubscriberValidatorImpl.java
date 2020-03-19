package com.epam.rd.july2019.spring_internet_provider.validator;


import com.epam.rd.july2019.spring_internet_provider.exception.ValidationProjectException;
import org.springframework.stereotype.Component;

@Component
public class SubscriberValidatorImpl implements SubscriberValidator {
    @Override
    public void validateSubscriberName(String name) {
        if (name == null) {
            throw new ValidationProjectException("Invalid credentials: " + name);
        }

    }

    @Override
    public boolean validateName(String name) {
        return !name.isEmpty();
    }
}
