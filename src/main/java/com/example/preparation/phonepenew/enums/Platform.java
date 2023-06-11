package com.example.preparation.phonepenew.enums;

public enum Platform {

    ANDROID(1),
    IOS(2),
    BOTH(3);

    private Integer value;

    Platform(Integer value) {
        this.value = value;
    }
}
