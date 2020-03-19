package com.epam.rd.july2019.spring_internet_provider.exception;

public class ApplicationProjectException extends RuntimeException {

    public ApplicationProjectException(String message) {
        super(message);
    }

    public ApplicationProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
