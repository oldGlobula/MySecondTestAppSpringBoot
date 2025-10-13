package ru.arkhipov.MySecondTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.arkhipov.MySecondTestAppSpringBoot.model.*;
import ru.arkhipov.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.arkhipov.MySecondTestAppSpringBoot.service.ValidationService;
import ru.arkhipov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@RestController
@Slf4j
public class MyController {

    private final ValidationService validationService;

    private final ModifyResponseService modifyResponseService;


    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.modifyResponseService = modifyResponseService;
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("response: {}", response);

        var httpStatus = HttpStatus.OK;

        try {
            validationService.isValid(bindingResult);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            if (e instanceof ValidationFailedException) {
                response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
                response.setErrorMessage(ErrorMessages.VALIDATION);
                httpStatus = HttpStatus.BAD_REQUEST;
            } else if (e instanceof UnsupportedCodeException) {
                response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
                response.setErrorMessage(ErrorMessages.UNSUPPORTED);
                httpStatus = HttpStatus.BAD_REQUEST;
            } else {
                response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
                response.setErrorMessage(ErrorMessages.UNKNOWN);
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }

        modifyResponseService.modify(response);

        log.info("response: {}", response);

        return new ResponseEntity<>(response, httpStatus);
    }
}
