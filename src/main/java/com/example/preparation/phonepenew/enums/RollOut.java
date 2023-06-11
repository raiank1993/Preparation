package com.example.preparation.phonepenew.enums;

public enum RollOut {
    PERCENTAGE(1),
    DEFAULT(3),
    BETA(2);

    private Integer value;

    RollOut(Integer value) {
        this.value = value;
    }
}
