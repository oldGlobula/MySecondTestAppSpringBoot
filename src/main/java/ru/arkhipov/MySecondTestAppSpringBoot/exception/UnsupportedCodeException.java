package ru.arkhipov.MySecondTestAppSpringBoot.exception;

public class UnsupportedCodeException extends ValidationFailedException {
    public UnsupportedCodeException(String message) {
        super(message);
    }
}
