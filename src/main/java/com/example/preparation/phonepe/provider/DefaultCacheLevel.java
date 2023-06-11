package com.example.preparation.phonepe.provider;

import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.ReadResponse;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.WriteResponse;

import java.util.List;

public class DefaultCacheLevel<Key, Value> implements ILevelCache<Key, Value>{
    @Override
    public WriteResponse set(Key key, Value value) {
        return null;
    }

    @Override
    public ReadResponse<Value> get(Key key) {
        return null;
    }

    @Override
    public List<Double> getUsages() {
        return null;
    }
}
