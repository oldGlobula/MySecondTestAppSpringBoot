package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{


    @Override
    public double calculate(Positions positions, double salary, double bonus, int workdays, boolean isLeapYear) {
        var daysInYear = isLeapYear ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workdays;
    }
}
