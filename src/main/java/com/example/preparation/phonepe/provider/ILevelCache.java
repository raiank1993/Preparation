package com.example.preparation.phonepe.provider;

import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.ReadResponse;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.WriteResponse;

import java.util.List;

public interface ILevelCache<Key, Value> {

    WriteResponse set(Key key, Value value);

    ReadResponse<Value> get(Key key);

    List<Double> getUsages();
}
