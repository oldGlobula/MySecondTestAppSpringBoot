package ru.arkhipov.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.ValidationFailedException;

import java.util.Objects;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            log.error("{}", Objects.requireNonNull(bindingResult.getFieldError()));
            throw new ValidationFailedException(Objects.requireNonNull(bindingResult.getFieldError()).toString());
        }
        else if (Objects.equals(bindingResult.getRawFieldValue("uid"), "123")) {
            log.error("uid was 123");
            throw new UnsupportedCodeException("uid cannot be 123");
        }
    }

}
