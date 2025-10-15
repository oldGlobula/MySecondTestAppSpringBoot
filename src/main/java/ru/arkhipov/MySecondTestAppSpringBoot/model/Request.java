package ru.arkhipov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    /***
     Уникальный идентификатор сообщения
     */
    @NotBlank
    @Size(max=32)
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    @NotBlank
    @Size(max=32)
    private String operationUid;
    /***
     * Имя системы отправителя
     */
    private String systemName;
    /***
     * Время создания сообщения
     */
    @NotBlank
    private String systemTime;
    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Должность
     */
    private Positions positions;
    /***
     * Ежегодная зарплата
     */
    private Integer salary;
    /***
     * Премиальный коэффициент
     */
    private Double bonus;
    /***
     * Рабочих дней в году
     */
    private Integer workDays;
    /***
     * Уникальный идентификатор коммуникации
     */
    @Max(100000)
    @Min(1)
    private Integer communicationId;
    /***
     * Уникальный идентификатор шаблона
     */
    private Integer templateId;
    /***
     * Код продукта
     */
    private Integer productCode;
    /***
     * Смс код
     */
    private Integer smsCode;

    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", position='" + positions + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", workDays=" + workDays +
                ", communicationId=" +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode" + smsCode +
                '}';
    }

}
