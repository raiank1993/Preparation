package com.example.preparation.phonepe.storage;


import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage<Key, Value> implements Storage<Key, Value>{
    private final Map<Key, Value> map;
    private final Integer capacity;

    public InMemoryStorage(Integer capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Key o, Value o2) {
        if(isStorageFull()){

        }
        map.put(o, o2);
    }

    @Override
    public Value get(Key o) {
        return map.get(o);
    }

    @Override
    public void remove(Key o) {
        map.remove(o);
    }

    @Override
    public double getCurrentUsages() {
        return ((double) map.size()) / ((double) capacity);
    }

    private boolean isStorageFull(){
        return map.size() == capacity;
    }
}
