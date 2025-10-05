package ru.arkhipov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ErrorCodes {
    EMPTY(""),
    VALIDATION_EXCEPTION("ValidationException"),
    UNSUPPORTED_EXCEPTION("UnsupportedException"),
    UNKNOWN_EXCEPTION("UnknownException");

    private final String code;

    ErrorCodes(String code) {
        this.code = code;
    }

    @JsonValue
    public String getName() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
