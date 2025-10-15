package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService {
    @Override
    public double calculate(Positions positions, double salary) {
        if (!positions.isManager()) throw new IllegalArgumentException("Only managers can have quarterly bonus");
        return salary * positions.getPositionCoefficient() / 4;
    }
}
