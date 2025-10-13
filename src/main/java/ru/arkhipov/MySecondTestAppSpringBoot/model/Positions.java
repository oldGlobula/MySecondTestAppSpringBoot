package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, true),
    SEN(3.0, false),
    PM(1.8, true),
    SUP(1.4, false);

    private final double positionCoefficient;
    private final boolean isManager;

    Positions(double positionCoefficient, boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }

}
