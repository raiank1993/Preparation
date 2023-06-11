package com.example.preparation.phonepenew.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class MetaData {

    private double appVersion;
    private double minVersion;
    private double maxVersion;
    private String osType;

}
