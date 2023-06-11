package com.example.preparation.phonepe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReadResponse<Value> {
    Value value;
    Double totalTime;
}
