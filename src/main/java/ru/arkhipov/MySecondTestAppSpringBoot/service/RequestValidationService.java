package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.ValidationFailedException;

import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors())
            throw new ValidationFailedException(Objects.requireNonNull(bindingResult.getFieldError()).toString());
        else if (Objects.equals(bindingResult.getRawFieldValue("uid"), "123"))
            throw new UnsupportedCodeException("uuid cannot be 123");
    }

}
