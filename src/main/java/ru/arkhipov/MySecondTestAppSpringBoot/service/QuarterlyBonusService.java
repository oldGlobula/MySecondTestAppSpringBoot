package ru.arkhipov.MySecondTestAppSpringBoot.service;

import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

public interface QuarterlyBonusService {

    double calculate(Positions positions, double salary);
}
