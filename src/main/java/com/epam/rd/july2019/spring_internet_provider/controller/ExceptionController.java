package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.exception.ValidationProjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="There is not name in the DB")
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void handleEmptyResultDataAccessException(){
        LOGGER.error("There is not name in the DB");
    }

    @ExceptionHandler(ValidationProjectException.class)
    public String handleValidationException(){
        LOGGER.error("ValidationProjectException handler executed");
        return "errorView";
    }
}
