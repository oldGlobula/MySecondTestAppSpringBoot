package ru.arkhipov.MySecondTestAppSpringBoot.service;

import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

public class QuarterlyBonusServiceImpl implements QuarterlyBonusService {
    @Override
    public double calculate(Positions positions, double salary) {
        if (!positions.isManager()) return 0;
        return salary * positions.getPositionCoefficient() / 4;
    }
}
