package ru.arkhipov.MySecondTestAppSpringBoot.exception;

import ru.arkhipov.MySecondTestAppSpringBoot.service.ValidationService;

public class ValidationFailedException extends Exception {

    public ValidationFailedException()
    {

    }
    public ValidationFailedException(String message) {
        super(message);
    }
}