package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    /***
     * Уникальный идентификатор сообщения
     */
    private String uid;

    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;

    /***
     * Время создания сообщения
     */
    private String systemTime;

    /***
     * Ежегодная премия
     */
    private Double annualBonus;

    /***
     * Маркер успеха
     */
    private Codes code;

    /***
     * Код ошибки
     */
    private ErrorCodes errorCode;

    /***
     * Сообщение об ошибке
     */
    private ErrorMessages errorMessage;

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + code + '\'' +
                ", annualBonus=" + annualBonus +
                ", templateId=" + errorCode +
                ", productCode=" + errorMessage +
                '}';
    }
}
