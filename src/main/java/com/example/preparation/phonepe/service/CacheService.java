package com.example.preparation.phonepe.service;

import afu.org.checkerframework.checker.nullness.qual.NonNull;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.ReadResponse;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.StatResponse;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.model.WriteResponse;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.provider.DefaultCacheLevel;
import in.gameskraft.communicationservice.controllers.facebook.phonepe.provider.ILevelCache;

import java.util.ArrayList;
import java.util.List;

public class CacheService<Key, Value> {
    private final ILevelCache<Key, Value> multiLevelCache;
    private final List<Double> lastReadTimes;
    private final List<Double> lastWriteTimes;
    private final int lastCount;

    public CacheService(@NonNull final DefaultCacheLevel<Key, Value> multiLevelCache, final int lastCount) {
        this.multiLevelCache = multiLevelCache;
        this.lastCount = lastCount;
        this.lastReadTimes = new ArrayList<>(lastCount);
        this.lastWriteTimes = new ArrayList<>(lastCount);
    }

    public WriteResponse set(@NonNull final Key key, @NonNull final Value value) {
        final WriteResponse writeResponse = multiLevelCache.set(key, value);
        addTimes(lastWriteTimes, writeResponse.getTimeTaken());
        return writeResponse;
    }

    public ReadResponse<Value> get(@NonNull final Key key) {
        final ReadResponse<Value> readResponse = multiLevelCache.get(key);
        addTimes(lastReadTimes, readResponse.getTotalTime());
        return readResponse;
    }

    public StatResponse stats() {
        return new StatResponse(getAvgReadTime(), getAvgWriteTime(), multiLevelCache.getUsages());
    }

    private Double getAvgReadTime() {
        return getSum(lastReadTimes)/lastReadTimes.size();
    }

    private Double getAvgWriteTime() {
        return getSum(lastWriteTimes)/lastWriteTimes.size();
    }

    private void addTimes(List<Double> times, Double time) {
        if (times.size() == this.lastCount) {
            times.remove(0);
        }

        times.add(time);
    }

    private Double getSum(List<Double> times) {
        Double sum = 0.0;
        for (Double time: lastReadTimes) {
            sum += time;
        }
        return sum;
    }
}
