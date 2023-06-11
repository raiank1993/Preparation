package com.example.preparation.phonepe.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StatResponse {
    private final Double avgReadTime;
    private final Double avgWriteTime;
    private final List<Double> usages;
}
