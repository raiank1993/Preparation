package com.example.preparation.phonepenew.service.strategy;

import in.gameskraft.communicationservice.controllers.facebook.phonepenew.enums.RollOut;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.interfaces.RollOutStrategy;

public class DefaultStrategy implements RollOutStrategy {
    @Override
    public RollOut strategy() {
        return RollOut.DEFAULT;
    }
}
