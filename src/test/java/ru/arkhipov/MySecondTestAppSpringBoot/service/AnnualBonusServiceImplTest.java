package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {

        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workdays = 243;
        double salary = 100_000.00;

        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bonus, workdays, false);

        double expected = 360_493.8271604938;

        assertThat(result).isEqualTo(expected);
    }
}