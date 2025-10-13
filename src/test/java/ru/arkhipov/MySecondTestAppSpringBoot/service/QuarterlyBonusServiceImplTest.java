package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuarterlyBonusServiceImplTest {

    @Test
    void calculate() {
        Positions positions = Positions.PM;

        double salary = 100_000.00;

        double result = new QuarterlyBonusServiceImpl().calculate(positions, salary);

        double expected = 45000;

        assertThat(result).isEqualTo(expected);
    }
}