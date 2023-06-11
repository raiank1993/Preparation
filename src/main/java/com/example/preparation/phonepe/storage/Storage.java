package com.example.preparation.phonepe.storage;


public interface Storage <Key, Value>{
    void add(Key key, Value value);
    Value get(Key key);
    void remove(Key key);

    double getCurrentUsages();
}
