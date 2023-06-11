package com.example.preparation.phonepenew.model;

import in.gameskraft.communicationservice.controllers.facebook.phonepenew.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Device {

    private List<App> appList;
    private String deviceName;
    private int id;
    private Platform platform;

}
