package com.example.preparation.phonepenew.service;

import in.gameskraft.communicationservice.controllers.facebook.phonepenew.enums.RollOut;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.interfaces.RollOutStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateApp {

    RollOutStrategy rollOutStrategy;

    public UpdateApp(RollOutStrategy strategy){
        this.rollOutStrategy = strategy;
    }

    public void executeApp(){
        RollOut rollout = rollOutStrategy.strategy();
        //do update the app

    }
}
